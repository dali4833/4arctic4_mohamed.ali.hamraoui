package com.example.demo.Controller;

import com.example.demo.Entity.DetailComposant;
import com.example.demo.service.DetailComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail-composants")
public class DetailComposantController {

    @Autowired
    private DetailComposantService detailComposantService;

    // Create a new DetailComposant
    @PostMapping
    public DetailComposant createDetailComposant(@RequestBody DetailComposant detailComposant) {
        return detailComposantService.createDetailComposant(detailComposant);
    }

    // Get a DetailComposant by ID
    @GetMapping("/{id}")
    public ResponseEntity<DetailComposant> getDetailComposantById(@PathVariable Long id) {
        DetailComposant detailComposant = detailComposantService.getDetailComposantById(id);
        if (detailComposant != null) {
            return ResponseEntity.ok(detailComposant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all DetailComposants
    @GetMapping
    public List<DetailComposant> getAllDetailComposants() {
        return detailComposantService.getAllDetailComposants();
    }

    // Update a DetailComposant by ID
    @PutMapping("/{id}")
    public ResponseEntity<DetailComposant> updateDetailComposant(@PathVariable Long id, @RequestBody DetailComposant detailComposantDetails) {
        DetailComposant updatedDetailComposant = detailComposantService.updateDetailComposant(id, detailComposantDetails);
        if (updatedDetailComposant != null) {
            return ResponseEntity.ok(updatedDetailComposant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a DetailComposant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetailComposant(@PathVariable Long id) {
        detailComposantService.deleteDetailComposant(id);
        return ResponseEntity.noContent().build();
    }
}