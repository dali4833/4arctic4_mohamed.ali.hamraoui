package com.example.demo.ServiceImp;

import com.example.demo.Entity.ChefCuisinier;
import com.example.demo.repository.ChefCuisinierRepository;
import com.example.demo.service.ChefCuisinierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChefCuisinierServiceImpl implements ChefCuisinierService {

    @Autowired
    private ChefCuisinierRepository chefCuisinierRepository;

    @Override
    public ChefCuisinier createChefCuisinier(ChefCuisinier chefCuisinier) {
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public ChefCuisinier getChefCuisinierById(Long id) {
        return chefCuisinierRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChefCuisinier> getAllChefs() {
        return chefCuisinierRepository.findAll();
    }

    @Override
    public ChefCuisinier updateChefCuisinier(Long id, ChefCuisinier chefCuisinier) {
        chefCuisinier.setIdChefCuisinier(id);
        return chefCuisinierRepository.save(chefCuisinier);
    }

    @Override
    public void deleteChefCuisinier(Long id) {
        chefCuisinierRepository.deleteById(id);
    }
}