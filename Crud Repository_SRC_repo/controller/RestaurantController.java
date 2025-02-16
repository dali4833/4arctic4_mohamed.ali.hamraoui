package com.example.demo.controller;

import com.example.demo.Restaurant;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

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
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        return restaurant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new restaurant
    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

//    // Update an existing restaurant
//    @PutMapping("/{id}")
//    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
//        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
//
//        if (!optionalRestaurant.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Restaurant restaurant = optionalRestaurant.get();
//        restaurant.setName(restaurantDetails.getName());
//        restaurant.setLocation(restaurantDetails.getLocation());
//
//        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
//        return ResponseEntity.ok(updatedRestaurant);
//    }

    // Delete a restaurant
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        if (!restaurantRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        restaurantRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}