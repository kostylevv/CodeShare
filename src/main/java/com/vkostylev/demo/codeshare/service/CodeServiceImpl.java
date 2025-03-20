package com.vkostylev.demo.codeshare.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.dto.CodeIdDto;
import com.vkostylev.demo.codeshare.dto.CodeMapper;
import com.vkostylev.demo.codeshare.model.Code;
import com.vkostylev.demo.codeshare.repository.CodeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CodeServiceImpl implements CodeSerivce {
    private final CodeRepository codeRepository;

    public CodeServiceImpl(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    @Override
    public Optional<CodeDto> getCode(long id) {
        Optional<Code> code = codeRepository.getCode(id);
        return code.map(CodeMapper::mapToCodeDto);
    }

    @Override
    public Optional<String> getJson(long id) {
        Optional<CodeDto> dto = getCode(id);
        if (dto.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
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
    public String newCode(String codeString) {
        Code code = codeRepository.addCode(codeString);
        CodeIdDto codeIdDto = CodeMapper.mapToCodeIdDto(code);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(codeIdDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }
}