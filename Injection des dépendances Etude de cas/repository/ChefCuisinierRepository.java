package com.example.demo.repository;

import com.example.demo.Entity.ChefCuisinier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefCuisinierRepository extends JpaRepository<ChefCuisinier, Long> {
}