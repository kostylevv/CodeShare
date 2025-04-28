package com.vkostylev.demo.codeshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @TODO add time and view limits to front: Note: if only one of the restrictions is applied, you should show only one of the above elements.
 * @TODO final check to spec
 * @TODO checkstyle
 */
@SpringBootApplication
public class CodeShareApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeShareApplication.class, args);
    }
}
