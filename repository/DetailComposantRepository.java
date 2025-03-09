package com.example.demo.repository;


import com.example.demo.Entity.DetailComposant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailComposantRepository extends JpaRepository<DetailComposant, Long> {
}

