package com.vkostylev.demo.codeshare.controller;

import com.vkostylev.demo.codeshare.service.CodeSerivce;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CodeController {
    private final CodeSerivce codeSerivce;

    public CodeController(CodeSerivce codeSerivce) {
        this.codeSerivce = codeSerivce;
    }

    @GetMapping(path = "/code")
    public ResponseEntity<String> getCodeHtml() {
        Optional<String> result = codeSerivce.getHtml(1L);

        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/api/code")
    public ResponseEntity<String> getCodeJson() {
        Optional<String> result = codeSerivce.getJson(1L);

        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());

    }



}