package com.example.scofs.model;

import lombok.Data;

@Data
public class User {
    public int id;
    public String name;
    public String institution;
    Profile profile;
}
