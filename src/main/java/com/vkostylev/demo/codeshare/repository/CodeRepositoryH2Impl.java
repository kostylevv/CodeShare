package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class CodeRepositoryH2Impl implements CrudCodeRepository, CodeRepository {
    @Override
    public Optional<Code> getCode(long id) {
        return Optional.empty();
    }

    @Override
    public Code addCode(String code) {
        return null;
    }

    @Override
    public List<Code> getLatest() {
        return List.of();
    }

    @Override
    public Optional<Code> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Code save(Code entity) {
        return null;
    }

    @Override
    public Iterable<Code> findAll() {
        return null;
    }
}
