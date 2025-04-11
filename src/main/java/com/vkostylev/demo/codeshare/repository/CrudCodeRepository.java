package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudCodeRepository extends CrudRepository<Code, String> {
    List<Code> findTop10ByOrderByDateDesc();

}
