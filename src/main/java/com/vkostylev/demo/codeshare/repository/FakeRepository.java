package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class FakeRepository implements CodeRepository {
    private static long counter = 0;
    private static final Map<Long, Code> codes = new HashMap<>();

    @Override
    public Optional<Code> getCode(long id) {
        return Optional.ofNullable(codes.get(id));
    }

    @Override
    public Code addCode(String code) {
        Code newCode = new Code(counter, code, LocalDate.now());
        codes.put(counter, newCode);
        counter++;
        return newCode;
    }

    @Override
    public List<Code> getLatest() {
        return codes.values().stream()
                        .sorted(Comparator.comparing(Code::getId).reversed())
                .limit(10)
                .toList();
    }

}