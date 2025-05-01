package com.vkostylev.demo.codeshare.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "snippets")
public class Code {
    @Id
    @Column(name = "uuid")
    private String id;

    @Column(name = "snippet")
    private String code;

    @Column(name = "snippet_date")
    private LocalDateTime date;

    @Column(name = "view_limit")
    private int viewLimit;

    @Column(name = "time_limit")
    private long timeLimit;

    @Transient
    private boolean viewLimited;

    public Code() { }

    public Code(String id, String code, LocalDateTime date, int viewLimit, long timeLimit) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.viewLimit = viewLimit;
        this.timeLimit = timeLimit;
        if (viewLimit > 0) {
            this.viewLimited = true;
        }
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

    public int getViewLimit() {
        return viewLimit;
    }

    public void setViewLimit(int viewLimit) {
        this.viewLimit = viewLimit;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isSecret() {
        return viewLimit > 0 || timeLimit > 0;
    }

    public boolean isViewLimited() {
        return viewLimited;
    }
}