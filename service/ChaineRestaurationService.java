package com.example.demo.service;

import com.example.demo.Entity.ChaineRestauration;
import java.util.List;

public interface ChaineRestaurationService {
    ChaineRestauration createChaineRestauration(ChaineRestauration chaineRestauration);
    ChaineRestauration getChaineRestaurationById(Long id);
    List<ChaineRestauration> getAllChaineRestaurations();
    ChaineRestauration updateChaineRestauration(Long id, ChaineRestauration chaineRestauration);
    void deleteChaineRestauration(Long id);
}