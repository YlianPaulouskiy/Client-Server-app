package com.exercise.demo.data.model;

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("name")
    private String name;

    @SerializedName("realname")
    private String realName;

    @SerializedName("team")
    private String team;

    @SerializedName("firstappearance")
    private String firstAppearance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
