package com.vkostylev.demo.codeshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @TODO modify latest to exclude secret snippets
 * @TODO check that time and view limits are added properly
 * @TODO add time and view limits to front
 * @TODO fix varchar type for long text
 */
@SpringBootApplication
public class CodeShareApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeShareApplication.class, args);
    }
}
