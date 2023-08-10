package com.example.scofs.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name = "events")
public class Event {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id")
   private long id;
   @Column(name = "name")
   private String name;
   @Column(name = "description")
   private String description;
   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "event_types_id")
   private EventTypes eventType;
   @JsonIgnore
   @Column(name = "deleted")
   private boolean deleted;

}
