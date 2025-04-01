package com.vkostylev.demo.codeshare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String code;

    private LocalDate date;

    public Code(long id, String code, LocalDate date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public Code() {

    }

    public String getCode() {
        return code;
    }

    public LocalDate getDate() {
        return date;
    }

    public long getId() {
        return id;
    }
}