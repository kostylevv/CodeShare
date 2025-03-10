package com.vkostylev.demo.codeshare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CodeDto(String code, @JsonFormat(pattern="yyyy-MM-dd") LocalDate date) {
    public CodeDto(String code) {
        this(code, LocalDate.now());
    }
}
