package com.example.scofs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "event_types")
public class EventTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

    @JsonIgnore
    @Column(name = "deleted")
    private boolean deleted;
}
