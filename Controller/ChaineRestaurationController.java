package com.example.demo.Controller;

import com.example.demo.Entity.ChaineRestauration;
import com.example.demo.service.ChaineRestaurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chaine-restaurations")
public class ChaineRestaurationController {

    @Autowired
    private ChaineRestaurationService chaineRestaurationService;

    // Create a new ChaineRestauration
    @PostMapping
    public ChaineRestauration createChaineRestauration(@RequestBody ChaineRestauration chaineRestauration) {
        return chaineRestaurationService.createChaineRestauration(chaineRestauration);
    }

    // Get a ChaineRestauration by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChaineRestauration> getChaineRestaurationById(@PathVariable Long id) {
        ChaineRestauration chaineRestauration = chaineRestaurationService.getChaineRestaurationById(id);
        if (chaineRestauration != null) {
            return ResponseEntity.ok(chaineRestauration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all ChaineRestaurations
    @GetMapping
    public List<ChaineRestauration> getAllChaineRestaurations() {
        return chaineRestaurationService.getAllChaineRestaurations();
    }

    // Update a ChaineRestauration by ID
    @PutMapping("/{id}")
    public ResponseEntity<ChaineRestauration> updateChaineRestauration(@PathVariable Long id, @RequestBody ChaineRestauration chaineRestaurationDetails) {
        ChaineRestauration updatedChaineRestauration = chaineRestaurationService.updateChaineRestauration(id, chaineRestaurationDetails);
        if (updatedChaineRestauration != null) {
            return ResponseEntity.ok(updatedChaineRestauration);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a ChaineRestauration by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChaineRestauration(@PathVariable Long id) {
        chaineRestaurationService.deleteChaineRestauration(id);
        return ResponseEntity.noContent().build();
    }
}