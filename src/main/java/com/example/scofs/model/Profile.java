package com.example.scofs.model;

import lombok.Data;

@Data
public class Profile {
    int id;
    String name;
    String Details;
    Project projects;
    Rank rank;
}
