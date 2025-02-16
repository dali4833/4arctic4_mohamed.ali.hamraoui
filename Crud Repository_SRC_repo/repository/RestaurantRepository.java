package com.example.demo.repository;

// Adjust to match your actual package

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {



}