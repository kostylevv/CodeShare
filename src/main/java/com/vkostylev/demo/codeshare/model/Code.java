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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    private LocalDate date;

    public Code(long id, String code, LocalDate date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public Code() {

    }

}