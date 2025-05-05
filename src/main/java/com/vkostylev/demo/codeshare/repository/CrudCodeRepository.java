package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Code;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrudCodeRepository extends CrudRepository<Code, String> {
    @Query("select c from Code c where c.timeLimit = 0 and c.viewLimit = 0 order by c.date desc limit 10")
    List<Code> findLatest();

}
