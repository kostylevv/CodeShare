package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;

import java.util.Optional;

public interface CodeRepository {
    public Optional<Code> getCode(long id);
    public Optional<Code> setCode(String code);
}
