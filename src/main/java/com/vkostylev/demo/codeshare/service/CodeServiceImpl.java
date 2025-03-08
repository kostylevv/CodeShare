package com.vkostylev.demo.codeshare.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.dto.HtmlCodeDto;
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
        return code.map(value -> new CodeDto(value.getCode()));
    }

    @Override
    public Optional<String> getHtml(long id) {
        Optional<CodeDto> dto = getCode(id);
        if (dto.isPresent()) {
            String html = HtmlCodeDto.get(dto.get());
            return Optional.of(html);
        } else {
            System.out.println("Dto not found");
            return Optional.empty();
        }
    }

    @Override
    public Optional<String> getJson(long id) {
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
        System.out.println("Dto not found");
        return Optional.empty();
    }
}