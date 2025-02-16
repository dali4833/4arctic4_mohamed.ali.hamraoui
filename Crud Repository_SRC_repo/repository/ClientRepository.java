package com.example.demo.repository;

// Adjust to match your actual package

import com.example.demo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Restaurant;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // You can define custom query methods here if needed
}