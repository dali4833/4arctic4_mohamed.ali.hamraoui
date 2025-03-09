package com.example.demo.ServiceImp;
import com.example.demo.Entity.DetailComposant;
import com.example.demo.repository.DetailComposantRepository;
import com.example.demo.service.DetailComposantService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailComposantServiceImpl implements DetailComposantService {

    @Autowired
    private DetailComposantRepository detailComposantRepository;

    @Override
    public DetailComposant createDetailComposant(DetailComposant detailComposant) {
        return detailComposantRepository.save(detailComposant);
    }

    @Override
    public DetailComposant getDetailComposantById(Long id) {
        return detailComposantRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailComposant> getAllDetailComposants() {
        return detailComposantRepository.findAll();
    }

    @Override
    public DetailComposant updateDetailComposant(Long id, DetailComposant detailComposant) {
        detailComposant.setIdDetailComposant(id);
        return detailComposantRepository.save(detailComposant);
    }

    @Override
    public void deleteDetailComposant(Long id) {
        detailComposantRepository.deleteById(id);
    }
}