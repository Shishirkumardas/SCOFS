package com.example.scofs.controllers;

import com.example.scofs.service.EventService;
import com.example.scofs.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class EventController {

    public static EventService eventService;



    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEvent(@RequestParam(required = false) String event) {
        Map<String, String> message = new HashMap<>();

        // if no input parameter, get all
        if (event == null) {
            List<Event> list = eventService.getAll(false);

            // if list is empty
            if (list.isEmpty()) {
                message.put("ApiMessage", "No available Event found in the database");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        // Get Event instance of the given input parameter
        Event instance = eventService.getEvent(event);
        if (instance == null) {

            // return message if no existing Event
            message.put("ApiMessage", "No Event found with ID/Name " + event);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
}
