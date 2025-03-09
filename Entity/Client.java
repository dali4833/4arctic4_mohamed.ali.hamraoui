package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all attributes
@Slf4j // For logging

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClient")
    private Long idClient; // Clé primaire

    private String identifiant;

    @Temporal(TemporalType.DATE)
    private Date datePremiereVisite;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Commande> commandes; // Liste des commandes associées


    public Client(String identifiant, Date datePremiereVisite) {
        this.identifiant = identifiant;
        this.datePremiereVisite = datePremiereVisite;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Date getDatePremiereVisite() {
        return datePremiereVisite;
    }

    public void setDatePremiereVisite(Date datePremiereVisite) {
        this.datePremiereVisite = datePremiereVisite;
    }
}
