package com.vkostylev.demo.codeshare.controller;

import com.vkostylev.demo.codeshare.dto.CodeDto;
import com.vkostylev.demo.codeshare.dto.NewCodeDto;
import com.vkostylev.demo.codeshare.service.CodeSerivce;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CodeController {
    private final CodeSerivce codeSerivce;

    public CodeController(CodeSerivce codeSerivce) {
        this.codeSerivce = codeSerivce;
    }

    @GetMapping(path = "/code/{id}")
    public String getCodeHtml(@PathVariable int id, Model model, HttpServletResponse response) {
        Optional<CodeDto> codeDto = codeSerivce.getCode(id);
        if (codeDto.isPresent()) {
            CodeDto result = codeDto.get();
            model.addAttribute("snippet", result.getCode());
            model.addAttribute("date", result.getDate());
            response.setStatus(HttpStatus.OK.value());
            return "code";
        } else {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return "nothing";
        }
    }

    @GetMapping(path = "/api/code/{id}")
    public ResponseEntity<String> getCodeJson(@PathVariable int id) {
        Optional<String> result = codeSerivce.getJson(id);
        return result.map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(s)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping(path = "/code/new")
    public String createCodeGet() {
        return "addnew";
    }

    @PostMapping(path = "/api/code/new")
    public ResponseEntity<String> createCodePost(@RequestBody NewCodeDto codeDto) {
        String result = codeSerivce.newCode(codeDto.code());
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping(path = "/code/latest")
    public String getLatest(Model model, HttpServletResponse response) {
        List<CodeDto> latest = codeSerivce.getLatest();
        model.addAttribute("snippets", latest);
        response.setStatus(HttpStatus.OK.value());
        return "latest";
    }

    @GetMapping(path = "/api/code/latest")
    public ResponseEntity<String> getLatestJson() {
        String result = codeSerivce.getLatestJson();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping(path = "/code/about")
    public String getAbout(HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        return "about";
    }

}