package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface CrudCodeRepository extends Repository<Code, Long> {
    Optional<Code> findById(Long id);

    Code save(Code entity);

    Iterable<Code> findAll();
}
