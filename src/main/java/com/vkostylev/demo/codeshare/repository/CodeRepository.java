package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;

import java.util.Optional;

public interface CodeRepository {
    Optional<Code> getCode(long id);
    Code addCode(String code);
}
