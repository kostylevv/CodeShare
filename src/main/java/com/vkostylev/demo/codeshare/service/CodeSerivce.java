package com.vkostylev.demo.codeshare.service;

import com.vkostylev.demo.codeshare.dto.CodeDto;

import java.util.Optional;

public interface CodeSerivce {
    public Optional<CodeDto> getCode(long id);
    public Optional<String> getHtml(long id);
    public Optional<String> getJson(long id);
}
