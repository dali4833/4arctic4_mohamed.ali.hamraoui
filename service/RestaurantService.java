package com.example.demo.service;

import com.example.demo.Entity.Restaurant;
import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(Long id);
    List<Restaurant> getAllRestaurants();
    Restaurant updateRestaurant(Long id, Restaurant restaurant);
    void deleteRestaurant(Long id);
}