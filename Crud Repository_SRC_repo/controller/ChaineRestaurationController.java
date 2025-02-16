package com.example.demo.controller;

import com.example.demo.ChaineRestauration;
import com.example.demo.Client;
import com.example.demo.Service.ChaineRestaurationService;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chaines-restauration")
public class ChaineRestaurationController {

    @Autowired
    private ChaineRestaurationService chaineRestaurationService;

    // Create a new chaine de restauration
    @PostMapping
    public ResponseEntity<ChaineRestauration> createChaineRestauration(@RequestBody ChaineRestauration chaineRestauration) {
        ChaineRestauration createdChaineRestauration = chaineRestaurationService.createChaineRestauration(chaineRestauration);
        return new ResponseEntity<>(createdChaineRestauration, HttpStatus.CREATED);
    }

    // Get all chaines de restauration
    @GetMapping
    public ResponseEntity<List<ChaineRestauration>> getAllChainesRestauration() {
        List<ChaineRestauration> chainesRestauration = chaineRestaurationService.getAllChainesRestauration();
        return new ResponseEntity<>(chainesRestauration, HttpStatus.OK);
    }

    // Get chaine de restauration by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChaineRestauration> getChaineRestaurationById(@PathVariable Long id) {
        return chaineRestaurationService.getChaineRestaurationById(id)
                .map(chaineRestauration -> new ResponseEntity<>(chaineRestauration, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a chaine de restauration
    @PutMapping("/{id}")
    public ResponseEntity<ChaineRestauration> updateChaineRestauration(@PathVariable Long id, @RequestBody ChaineRestauration chaineRestaurationDetails) {
        ChaineRestauration updatedChaineRestauration = chaineRestaurationService.updateChaineRestauration(id, chaineRestaurationDetails);
        return new ResponseEntity<>(updatedChaineRestauration, HttpStatus.OK);
    }

    // Delete a chaine de restauration
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChaineRestauration(@PathVariable Long id) {
        chaineRestaurationService.deleteChaineRestauration(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}