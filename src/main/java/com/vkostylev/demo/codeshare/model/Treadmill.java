package com.vkostylev.demo.codeshare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// an annotation goes here
@Entity
public class Treadmill {
    @Id
    private String code;
    private String model;

    public Treadmill(String code, String model) {
        this.code = code;
        this.model = model;
    }

    public Treadmill() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}