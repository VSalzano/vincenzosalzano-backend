package com.gestioneincendi.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AllarmeController {

    @PostMapping("/allarmeincendio")
    public void inviaAllarme(@RequestBody String message) {
        System.out.println("Allarme ricevuto: " + message);


        if (message.contains("Allarme Incendio")) {
            
           
       
        }
    }
}
