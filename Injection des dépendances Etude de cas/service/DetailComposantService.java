package com.example.demo.service;

import com.example.demo.Entity.DetailComposant;
import java.util.List;

public interface DetailComposantService {
    DetailComposant createDetailComposant(DetailComposant detailComposant);
    DetailComposant getDetailComposantById(Long id);
    List<DetailComposant> getAllDetailComposants();
    DetailComposant updateDetailComposant(Long id, DetailComposant detailComposant);
    void deleteDetailComposant(Long id);
}