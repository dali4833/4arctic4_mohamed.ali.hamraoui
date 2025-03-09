package com.example.demo.service;

import com.example.demo.Entity.ChefCuisinier;
import java.util.List;

public interface ChefCuisinierService {
    ChefCuisinier createChefCuisinier(ChefCuisinier chefCuisinier);
    ChefCuisinier getChefCuisinierById(Long id);
    List<ChefCuisinier> getAllChefs();
    ChefCuisinier updateChefCuisinier(Long id, ChefCuisinier chefCuisinier);
    void deleteChefCuisinier(Long id);
}