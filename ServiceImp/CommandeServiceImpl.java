package com.example.demo.ServiceImp;

import com.example.demo.Entity.Commande;
import com.example.demo.repository.CommandeRepository;
import com.example.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        commande.setIdCommande(id);
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}