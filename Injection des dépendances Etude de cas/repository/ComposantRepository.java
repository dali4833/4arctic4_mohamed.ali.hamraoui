package com.example.demo.repository;

import com.example.demo.Entity.Composant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposantRepository extends JpaRepository<Composant, Long> {
}