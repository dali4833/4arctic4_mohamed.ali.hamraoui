package com.example.demo.ServiceImp;

import com.example.demo.Entity.ChaineRestauration;
import com.example.demo.repository.ChaineRestaurationRepository;
import com.example.demo.service.ChaineRestaurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaineRestaurationServiceImpl implements ChaineRestaurationService {

    @Autowired
    private ChaineRestaurationRepository chaineRestaurationRepository;

    @Override
    public ChaineRestauration createChaineRestauration(ChaineRestauration chaineRestauration) {
        return chaineRestaurationRepository.save(chaineRestauration);
    }

    @Override
    public ChaineRestauration getChaineRestaurationById(Long id) {
        return chaineRestaurationRepository.findById(id).orElse(null);
    }

    @Override
    public List<ChaineRestauration> getAllChaineRestaurations() {
        return chaineRestaurationRepository.findAll();
    }

    @Override
    public ChaineRestauration updateChaineRestauration(Long id, ChaineRestauration chaineRestauration) {
        chaineRestauration.setIdChaineRestauration(id);
        return chaineRestaurationRepository.save(chaineRestauration);
    }

    @Override
    public void deleteChaineRestauration(Long id) {
        chaineRestaurationRepository.deleteById(id);
    }
}