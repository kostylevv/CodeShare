package com.vkostylev.demo.codeshare.model;

import java.time.LocalDate;

public class Code {
    private final long id;
    private String code;

    private LocalDate date;

    public Code(long id, String code, LocalDate date) {
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