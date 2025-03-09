package com.example.demo.Controller;

import com.example.demo.Entity.ChefCuisinier;
import com.example.demo.service.ChefCuisinierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chef-cuisiniers")
public class ChefCuisinierController {

    @Autowired
    private ChefCuisinierService chefCuisinierService;

    // Create a new ChefCuisinier
    @PostMapping
    public ChefCuisinier createChefCuisinier(@RequestBody ChefCuisinier chefCuisinier) {
        return chefCuisinierService.createChefCuisinier(chefCuisinier);
    }

    // Get a ChefCuisinier by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChefCuisinier> getChefCuisinierById(@PathVariable Long id) {
        ChefCuisinier chefCuisinier = chefCuisinierService.getChefCuisinierById(id);
        if (chefCuisinier != null) {
            return ResponseEntity.ok(chefCuisinier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all ChefCuisiniers
    @GetMapping
    public List<ChefCuisinier> getAllChefCuisiniers() {
        return chefCuisinierService.getAllChefs();
    }

    // Update a ChefCuisinier by ID
    @PutMapping("/{id}")
    public ResponseEntity<ChefCuisinier> updateChefCuisinier(@PathVariable Long id, @RequestBody ChefCuisinier chefCuisinierDetails) {
        ChefCuisinier updatedChefCuisinier = chefCuisinierService.updateChefCuisinier(id, chefCuisinierDetails);
        if (updatedChefCuisinier != null) {
            return ResponseEntity.ok(updatedChefCuisinier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a ChefCuisinier by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChefCuisinier(@PathVariable Long id) {
        chefCuisinierService.deleteChefCuisinier(id);
        return ResponseEntity.noContent().build();
    }
}