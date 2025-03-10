package com.vkostylev.demo.codeshare.model;

import java.time.LocalDate;

public class Code {
    private long id;
    private String code;

    private LocalDate date;

    public Code(String code, LocalDate date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

}