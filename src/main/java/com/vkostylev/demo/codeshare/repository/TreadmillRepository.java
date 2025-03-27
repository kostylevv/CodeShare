package com.vkostylev.demo.codeshare.repository;

import com.vkostylev.demo.codeshare.model.Treadmill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreadmillRepository extends CrudRepository<Treadmill, String> {

}