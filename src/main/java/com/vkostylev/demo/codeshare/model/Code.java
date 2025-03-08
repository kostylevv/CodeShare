package com.vkostylev.demo.codeshare.model;

public class Code {
    private long id;
    private String code;

    public Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}