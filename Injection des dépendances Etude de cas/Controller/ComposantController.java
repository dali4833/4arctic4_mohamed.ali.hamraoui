package com.example.demo.Controller;

import com.example.demo.Entity.Composant;
import com.example.demo.service.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composants")
public class ComposantController {

    @Autowired
    private ComposantService composantService;

    // Create a new Composant
    @PostMapping
    public Composant createComposant(@RequestBody Composant composant) {
        return composantService.createComposant(composant);
    }

    // Get a Composant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Composant> getComposantById(@PathVariable Long id) {
        Composant composant = composantService.getComposantById(id);
        if (composant != null) {
            return ResponseEntity.ok(composant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all Composants
    @GetMapping
    public List<Composant> getAllComposants() {
        return composantService.getAllComposants();
    }

    // Update a Composant by ID
    @PutMapping("/{id}")
    public ResponseEntity<Composant> updateComposant(@PathVariable Long id, @RequestBody Composant composantDetails) {
        Composant updatedComposant = composantService.updateComposant(id, composantDetails);
        if (updatedComposant != null) {
            return ResponseEntity.ok(updatedComposant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Composant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComposant(@PathVariable Long id) {
        composantService.deleteComposant(id);
        return ResponseEntity.noContent().build();
    }
}