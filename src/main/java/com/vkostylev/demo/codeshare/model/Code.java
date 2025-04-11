package com.vkostylev.demo.codeshare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Code {
    @Id
    private String id;

    private String code;
    private LocalDateTime date;

    public Code() {

    }

    public Code(String id, String code, LocalDateTime date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}