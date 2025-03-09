package com.example.demo.service;

import com.example.demo.Entity.Composant;
import java.util.List;

public interface ComposantService {
    Composant createComposant(Composant composant);
    Composant getComposantById(Long id);
    List<Composant> getAllComposants();
    Composant updateComposant(Long id, Composant composant);
    void deleteComposant(Long id);
}