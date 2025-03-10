package com.vkostylev.demo.codeshare.dto;

public class HtmlCodeDto {
    private static final String PART1 = "<html>\n" +
            "<head>\n" +
            "    <title>Code</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    <pre>\n";
    private static final String PART2 = "</pre>\n";

    private static final String PART3 = "<span id=\"load_date\">";

    private static final String PART4 =  "</span>\n" +
            "</body>\n" +
            "</html>";



    public static String get(CodeDto dto){
        return PART1 +
                dto.code() +
                PART2 +
                PART3 +
                dto.date() +
                PART4;

    }
}