package com.vkostylev.demo.codeshare.dto;

import com.vkostylev.demo.codeshare.model.Code;

public class CodeMapper {
    public static Code mapToCode(CodeDto dto) {
        return new Code(dto.code(), dto.date());
    }

    public static CodeDto mapToCodeDto(Code code) {
        return new CodeDto(code.getCode(), code.getDate());
    }
}