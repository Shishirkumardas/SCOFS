package com.example.scofs.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/user")
@RestController
public class UserController {
    @GetMapping(path = "/get-user", produces = MediaType.APPLICATION_JSON_VALUE)
    private static void getUserById(){

    }
    @PostMapping(path = "/add-user")
    private static void addUser(){

    }
    @DeleteMapping(path = "delete-user")
    private static void deleteUser(){

    }
}
