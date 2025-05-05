package com.vkostylev.demo.codeshare.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CodeDto {
    private final String code;
    private final String date;

    @JsonProperty("views")
    private final int viewLimit;

    @JsonProperty("time")
    private final long timeLimit;

    @JsonIgnore
    private final boolean viewLimited;

    public CodeDto(String code, String date, int viewLimit, long timeLimit, boolean viewLimited) {
        this.code = code;
        this.date = date;
        this.viewLimit = viewLimit;
        this.timeLimit = timeLimit;
        this.viewLimited = viewLimited;
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
    public long getTimeLimit() {
        return timeLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CodeDto codeDto = (CodeDto) o;
        return Objects.equals(code, codeDto.code);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(code);
    }

    public boolean isViewLimited() {
        return viewLimited;
    }
}
