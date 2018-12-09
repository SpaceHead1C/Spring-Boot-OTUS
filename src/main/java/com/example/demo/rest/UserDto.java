package com.example.demo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {
    private String id;
    private String name;

    @JsonProperty("user_id")
    public String getIs() { return id; }

    public void setId(String id) { this.id = id; }

    @JsonProperty("user_name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
