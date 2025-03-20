package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class FakeRepository implements CodeRepository {
    private static long counter = 0;
    private static final Map<Long, Code> codes = new HashMap<>();

    @Override
    public Optional<Code> getCode(long id) {
        return Optional.of(codes.get(id));
    }

    @Override
    public Code addCode(String code) {
        Code newCode = new Code(counter, code, LocalDate.now());
        codes.put(counter, newCode);
        counter++;
        return newCode;
    }

}