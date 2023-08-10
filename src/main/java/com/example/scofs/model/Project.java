package com.example.scofs.model;

import lombok.Data;

@Data
public class Project {
    int id;
    String description;
    Profile profile;
    Rank rank;
}
