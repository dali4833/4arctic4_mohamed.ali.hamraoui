package com.example.demo.Service.impl;

import com.example.demo.Restaurant;
import com.example.demo.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
       return restaurantRepository.save(restaurant);

    }

        @Override
        public Restaurant getRestaurantById(Long id) {
            return restaurantRepository.findById(id).orElse(null);
        }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant restaurant) {


        return restaurant;
    }


    @Override
    public void deleteRestaurant(Long id) {
         restaurantRepository.deleteById(id);
    }

    public RestaurantRepository getRestaurantRepository() {
        return restaurantRepository;
    }

    public void setRestaurantRepository(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
}

