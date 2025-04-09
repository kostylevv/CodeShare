package com.vkostylev.demo.codeshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * V: decide on date format including time zone: duration
 *
 *
 * @TODO add UUID, change repo, service, controller
 * @TODO add time and view limits to model and to DB
 * @TODO add time and view limits to repo, serice, controller
 * @TODO add time and view limits to front
 * @TODO check that time and view limits are added properly
 * @TODO modify latest to exclude secret snippets
 * @TODO implement limit logic
 * @TODO implement time limit logic
 */
@SpringBootApplication
public class CodeShareApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeShareApplication.class, args);
    }
}
