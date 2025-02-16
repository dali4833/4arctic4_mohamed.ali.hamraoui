package com.example.demo.Service.impl;
import com.example.demo.Client;
import com.example.demo.Service.ClientService;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.MenuRepository;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client updateClient(Long id, Client clientDetails) {
//        Client client = clientRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
//
//        client.setFirstName(clientDetails.getFirstName());
//        client.setLastName(clientDetails.getLastName());
//        client.setEmail(clientDetails.getEmail());
//        client.setIdentifiant(clientDetails.getIdentifiant());
//        client.setDatePremiereVisite(clientDetails.getDatePremiereVisite());
//
//        return clientRepository.save(client);
        return clientDetails;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
