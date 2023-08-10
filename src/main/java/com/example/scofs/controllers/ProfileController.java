package com.example.scofs.controllers;

import com.example.scofs.model.Profile;
import com.example.scofs.service.ProfileService;
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
public class ProfileController {
    public static ProfileService profileService;



    @GetMapping(path = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProfile(@RequestParam(required = false) String profile) {
        Map<String, String> message = new HashMap<>();

        // if no input parameter, get all
        if (profile == null) {
            List<Profile> list = profileService.getAll(false);

            // if list is empty
            if (list.isEmpty()) {
                message.put("ApiMessage", "No available Profile found in the database");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

        // Get Profile instance of the given input parameter
        Profile instance = profileService.getProfile(profile);
        if (instance == null) {

            // return message if no existing Profile
            message.put("ApiMessage", "No Profile found with ID/Name " + profile);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(instance, HttpStatus.OK);
    }
}
