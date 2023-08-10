package com.example.scofs.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    @GetMapping(path = "/get-admin", produces = MediaType.APPLICATION_JSON_VALUE)
    private static void getAdminById(){

    }
    @PostMapping(path = "/add-admin")
    private static void addAdmin(){

    }
    @DeleteMapping(path = "delete-admin")
    private static void deleteAdmin(){

    }

}
