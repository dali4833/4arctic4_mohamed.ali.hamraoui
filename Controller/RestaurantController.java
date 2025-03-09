package com.example.demo.Controller;

import com.example.demo.Entity.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Get all restaurants
    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Get a restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new restaurant
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Update an existing restaurant
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setNom(restaurantDetails.getNom());
                    restaurant.setNbPlacesMax(restaurantDetails.getNbPlacesMax());
                    restaurant.setChaineRestauration(restaurantDetails.getChaineRestauration());
                    Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
                    return ResponseEntity.ok(updatedRestaurant);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a restaurant
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
//        return restaurantRepository.findById(id)
//                .map(restaurant -> {
//                    restaurantRepository.delete(restaurant);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElse(ResponseEntity.notFound().build());
//    }
}