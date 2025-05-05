package com.vkostylev.demo.codeshare;

import com.vkostylev.demo.codeshare.model.Code;
import com.vkostylev.demo.codeshare.repository.CrudCodeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
public class RepositoryTests {

    @Autowired
    CrudCodeRepository crudCodeRepository;

    @Test
    void contextLoads() {}

    @Test
    void snippetWithLimitsIsAddedSuccessfully() throws Exception {

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        Code code = new Code(randomUUIDString, "test code string", LocalDateTime.now(), 100, 1000);
        Code addedCode = crudCodeRepository.save(code);
        Assertions.assertNotNull(addedCode);
        Assertions.assertEquals(100, addedCode.getViewLimit());
        Assertions.assertEquals(1000, addedCode.getTimeLimit());

    }
}
