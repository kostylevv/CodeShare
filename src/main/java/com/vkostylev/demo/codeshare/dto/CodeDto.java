package com.vkostylev.demo.codeshare.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CodeDto {
    private final long id;
    private final String code;

    @JsonFormat(pattern="yyyy-MM-dd")
    private final LocalDate date;

    public CodeDto(long id, String code, LocalDate date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getId() {
        return id;
    }
}
