package com.vkostylev.demo.codeshare.dto;

import com.vkostylev.demo.codeshare.model.Code;

public class CodeMapper {
    public static CodeDto mapToCodeDto(Code code) {
        return new CodeDto(code.getId(), code.getCode(), code.getDate());
    }
    public static CodeIdDto mapToCodeIdDto(Code code) {return new CodeIdDto(code.getId());}
}