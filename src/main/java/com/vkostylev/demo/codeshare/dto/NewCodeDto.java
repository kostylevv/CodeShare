package com.vkostylev.demo.codeshare.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record NewCodeDto(
        @Size(min = 1, max = 1000)
        String code,

        @Min(value = 0)
        int views,

        @Min(value = 0)
        int time) {
}
