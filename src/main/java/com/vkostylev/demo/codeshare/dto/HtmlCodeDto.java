package com.vkostylev.demo.codeshare.dto;

public class HtmlCodeDto {
    private static final String PART1 = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n";
    private static final String PART2 =
            "</pre>\n" +
            "</body>\n" +
            "</html>";

    public static String get(CodeDto dto){
        return PART1 +
                dto.code() +
                PART2;
    }
}