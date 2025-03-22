package com.vkostylev.demo.codeshare.dto;

public class CodeDto {
    private final String code;
    private final String date;

    public CodeDto(String code, String date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

}
