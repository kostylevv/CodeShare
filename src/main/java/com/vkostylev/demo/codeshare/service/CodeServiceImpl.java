package com.vkostylev.demo.codeshare.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.dto.CodeIdDto;
import com.vkostylev.demo.codeshare.dto.CodeMapper;
import com.vkostylev.demo.codeshare.model.Code;
import com.vkostylev.demo.codeshare.repository.CrudCodeRepository;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CodeServiceImpl implements CodeSerivce {
    private final CrudCodeRepository codeRepository;

    public CodeServiceImpl(CrudCodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public Optional<CodeDto> getCode(String id) {
        Optional<Code> code = codeRepository.findById(id);
        //if code isSecret return getSecretCode
        if (code.isPresent() && code.get().isSecret()) {
            return getSecret(code.get());
        }
        return code.map(CodeMapper::mapToCodeDto);
    }

    public Optional<CodeDto> getSecret(Code code) {
        if (code.getViewLimit() > 0) {
            int viewLimit = code.getViewLimit() - 1;
            code.setViewLimit(viewLimit);
            if (viewLimit == 0) {
                codeRepository.deleteById(code.getId());
                return Optional.empty();
            }
        }

        if (code.getTimeLimit() > 0) {
            Duration durationOfLimit = Duration.ofSeconds(code.getTimeLimit());
            LocalDateTime deadline = LocalDateTime.now().plus(durationOfLimit);
            if (deadline.isBefore(LocalDateTime.now())) {
                codeRepository.deleteById(code.getId());
                return Optional.empty();
            }
        }
        return Optional.of(CodeMapper.mapToCodeDto(code));
    }

    /*
    private getSecretCode() {
        if (view_limit > 0) {
            view_limit--;
            if (view_limit == 0) {
                deleteFromDB, return empty;
            }
        }

        if (time_limit >0) {
            Period period = Period.of(time_limit);
            LDT now = LDT.NOW();
            LDT deadline = LDT.from(_date_).plus(period);

            if (now.isAfer(deadline)) {
                deleteformDB, return empty;
            }
        }
        return map etc;
    }
     */

    @Override
    public Optional<String> getJson(String id) {
        Optional<CodeDto> dto = getCode(id);
        if (dto.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return Optional.of(objectMapper.writeValueAsString(dto.get()));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public String newCode(String codeString, int viewLimit, int timeLimit) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        Code code = new Code(randomUUIDString, codeString, LocalDateTime.now(), viewLimit, timeLimit);
        Code addedCode = codeRepository.save(code);
        CodeIdDto codeIdDto = CodeMapper.mapToCodeIdDto(addedCode);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(codeIdDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<CodeDto> getLatest() {
        return codeRepository.findTop10ByOrderByDateDesc().stream().map(CodeMapper::mapToCodeDto).collect(Collectors.toList());
    }

    @Override
    public String getLatestJson() {
        List<CodeDto> codes = getLatest();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(codes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}