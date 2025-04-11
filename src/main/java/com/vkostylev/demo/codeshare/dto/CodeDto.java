package com.vkostylev.demo.codeshare.dto;

public class CodeDto {
    private final String code;
    private final String date;
    private final int viewLimit;
    private final int timeLimit;

    public CodeDto(String code, String date, int viewLimit, int timeLimit) {
        this.code = code;
        this.date = date;
        this.viewLimit = viewLimit;
        this.timeLimit = timeLimit;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public int getViewLimit() {
        return viewLimit;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
}
