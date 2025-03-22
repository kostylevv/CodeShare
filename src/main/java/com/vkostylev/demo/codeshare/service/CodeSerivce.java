package com.vkostylev.demo.codeshare.service;

import com.vkostylev.demo.codeshare.dto.CodeDto;

import java.util.List;
import java.util.Optional;

public interface CodeSerivce {
    Optional<CodeDto> getCode(long id);
    Optional<String> getJson(long id);
    String newCode(String codeString);
    List<CodeDto> getLatest();
    String getLatestJson();

}
