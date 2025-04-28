package com.vkostylev.demo.codeshare;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.service.CodeSerivce;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ServiceTests {

    @Autowired
    CodeSerivce codeSerivce;

    @Test
    void contextLoads() {
    }

    @Test
    void viewLimitedSnippetDissapears() throws Exception {
        String vls = "VIEW_LIMITED_SNIPPET";
        int viewLimit = 5;
        String addedUuidJson = codeSerivce.newCode(vls, viewLimit, 0);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(addedUuidJson);
        JsonNode id = root.path("id");
        String addedUuid = id.asText();


        Optional<CodeDto> codeDto = codeSerivce.getCode(addedUuid);

        Assertions.assertTrue(codeDto.isPresent());
        Assertions.assertEquals(vls, codeDto.get().getCode());
        Assertions.assertEquals(viewLimit - 1, codeDto.get().getViewLimit());
    }

    @Test
    void timeLimitedSnippetDissapears() throws Exception {
        String tls = "TIME_LIMITED_SNIPPET";
        int timeLimitSeconds = 10;
        String addedUuidJson = codeSerivce.newCode(tls, 0, timeLimitSeconds);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(addedUuidJson);
        JsonNode id = root.path("id");
        String addedUuid = id.asText();

        Optional<CodeDto> codeDto = codeSerivce.getCode(addedUuid);
        Assertions.assertTrue(codeDto.isPresent());

        Thread.sleep(timeLimitSeconds * 1000 + 1);

        Optional<CodeDto> codeDto2 = codeSerivce.getCode(addedUuid);
        Assertions.assertTrue(codeDto2.isEmpty());

    }

    @Test
    void regularSnippetIsVisibleInLatest() throws Exception {
        String tls = "SUPER_REGULAR_SNIPPET";
        String addedUuidJson = codeSerivce.newCode(tls, 0, 0);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(addedUuidJson);
        JsonNode id = root.path("id");
        String addedUuid = id.asText();

        Optional<CodeDto> codeDto = codeSerivce.getCode(addedUuid);
        Assertions.assertTrue(codeDto.isPresent());

        List<CodeDto> latest = codeSerivce.getLatest();
        Assertions.assertTrue(latest.contains(codeDto.get()));
    }

    @Test
    void viewLimitedIsNotVisibleInLatest() throws Exception {
        String vls = "VIEW_LIMITED_SNIPPET_NOT_VISIBLE";
        String addedUuidJson = codeSerivce.newCode(vls, 10, 0);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(addedUuidJson);
        JsonNode id = root.path("id");
        String addedUuid = id.asText();

        Optional<CodeDto> codeDto = codeSerivce.getCode(addedUuid);
        Assertions.assertTrue(codeDto.isPresent());

        List<CodeDto> latest = codeSerivce.getLatest();
        Assertions.assertFalse(latest.contains(codeDto.get()));

    }

    @Test
    void timeLimitedIsNotVisibleInLatest() throws Exception {
        String tls = "TIME_LIMITED_SNIPPET_NOT_VISIBLE";
        String addedUuidJson = codeSerivce.newCode(tls, 0, 10);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(addedUuidJson);
        JsonNode id = root.path("id");
        String addedUuid = id.asText();

        Optional<CodeDto> codeDto = codeSerivce.getCode(addedUuid);
        Assertions.assertTrue(codeDto.isPresent());

        List<CodeDto> latest = codeSerivce.getLatest();
        Assertions.assertFalse(latest.contains(codeDto.get()));

    }


}
