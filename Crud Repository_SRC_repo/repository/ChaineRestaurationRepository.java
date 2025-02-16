package com.example.demo.repository;

import com.example.demo.ChaineRestauration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChaineRestaurationRepository extends JpaRepository<ChaineRestauration, Long> {
    // Custom query methods can be defined here if needed
}