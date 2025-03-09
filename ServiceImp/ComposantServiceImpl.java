package com.example.demo.ServiceImp;


import com.example.demo.Entity.Composant;
import com.example.demo.repository.ComposantRepository;
import com.example.demo.service.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantServiceImpl implements ComposantService {

    @Autowired
    private ComposantRepository composantRepository;

    @Override
    public Composant createComposant(Composant composant) {
        return composantRepository.save(composant);
    }

    @Override
    public Composant getComposantById(Long id) {
        return composantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Composant> getAllComposants() {
        return composantRepository.findAll();
    }

    @Override
    public Composant updateComposant(Long id, Composant composant) {
        composant.setIdComposant(id);
        return composantRepository.save(composant);
    }

    @Override
    public void deleteComposant(Long id) {
        composantRepository.deleteById(id);
    }
}
