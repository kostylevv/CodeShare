package com.vkostylev.demo.codeshare.dto;

import com.vkostylev.demo.codeshare.model.Code;

import java.time.format.DateTimeFormatter;

public class CodeMapper {
    public static CodeDto mapToCodeDto(Code code) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yy-MM-dd");
        String dateText = code.getDate().format(formatters);
        return new CodeDto(code.getCode(), dateText);
    }
    public static CodeIdDto mapToCodeIdDto(Code code) {
        return new CodeIdDto(String.valueOf(code.getId()));}
}