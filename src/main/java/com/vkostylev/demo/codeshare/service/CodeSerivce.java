package com.vkostylev.demo.codeshare.service;

import com.vkostylev.demo.codeshare.dto.CodeDto;

import java.util.List;
import java.util.Optional;

public interface CodeSerivce {
    Optional<CodeDto> getCode(String id);
    Optional<String> getJson(String id);
    String newCode(String codeString, int viewLimit, int timeLimit);
    List<CodeDto> getLatest();
    String getLatestJson();

}
