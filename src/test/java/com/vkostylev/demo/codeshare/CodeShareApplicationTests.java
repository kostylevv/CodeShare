package com.vkostylev.demo.codeshare;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vkostylev.demo.codeshare.dto.CodeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeShareApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void snippetWithWrongIdIsNotFound() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/code/" + UUID.randomUUID(), String.class);
        assertThat(response.getStatusCode().is4xxClientError()).isTrue();
    }

    @Test
    void snippetIsAddedAndThenGetSuccessfully() throws Exception {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss");
        String dateTime = LocalDateTime.now().format(formatters);
        CodeDto newCodeDto = new CodeDto("code", dateTime, 0, 0);
        ResponseEntity<String> response = restTemplate.postForEntity("/api/code/new", newCodeDto,
                String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode id = root.path("id");
        ResponseEntity<String> response2 = restTemplate.getForEntity("/api/code/" + id.asText(), String.class);
        assertThat(response2.getStatusCode().is2xxSuccessful()).isTrue();
    }

}
