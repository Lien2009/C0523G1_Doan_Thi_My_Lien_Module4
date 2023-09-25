package com.example.ex2.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private int id;
    @NotEmpty(message = "Require not empty!")
    @Size(max = 800,message = "Less than 800 characters!")
    @Pattern(regexp = "^[\\w+\\s*]+$", message = "Does not contain special characters!")
    private String name;
    @NotEmpty(message = "Require not empty!")
    @Size(max = 800,message = "Less than 800 characters!")
    @Pattern(regexp = "^[\\w+\\s*]+$", message = "Does not contain special characters!")
    private String singer;
    @NotEmpty(message = "Require not empty!")
    @Size(max = 800,message = "Less than 800 characters!")
    @Pattern(regexp = "^[\\w+[\\s\\,]*]+$", message = "Does not contain special characters!")
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
