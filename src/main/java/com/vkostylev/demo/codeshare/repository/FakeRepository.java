package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FakeRepository implements CodeRepository {
    Code code = new Code("this is fake code");

    @Override
    public Optional<Code> getCode(long id) {
        return Optional.of(code);
    }
}