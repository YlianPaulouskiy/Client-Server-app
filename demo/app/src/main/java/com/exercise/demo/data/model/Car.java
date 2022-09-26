package com.exercise.demo.data.model;

import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("id")
    private Long id;
    @SerializedName("mark")
    private String  mark;
    @SerializedName("doorCount")
    private int doorCount;
    @SerializedName("accounting")
    private Boolean accounting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public Boolean getAccounting() {
        return accounting;
    }

    public void setAccounting(Boolean accounting) {
        this.accounting = accounting;
    }
}
