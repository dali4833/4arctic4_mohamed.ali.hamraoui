package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all attributes
@Slf4j // For logging

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Commande")
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommande")
    private Long idCommande; // Clé primaire

    private LocalDateTime dateCommande;
    private String typeMenu; // Add other relevant fields
    private Integer pourcentageRemise;
    private Float totalRemise;
    private Float totalCommande;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false) // Foreign key for Client
    private Client client; // Référence au Client

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false) // Foreign key for Menu
    private Menu menu; // Référence au Menu

    public Commande(Client client, LocalDateTime dateCommande, String typeMenu, Menu menu) {
        this.client = client;
        this.dateCommande = dateCommande;
        this.typeMenu = typeMenu;
        this.menu = menu;
    }

    // Getters and Setters
    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Integer getPourcentageRemise() {
        return pourcentageRemise;
    }

    public void setPourcentageRemise(Integer pourcentageRemise) {
        this.pourcentageRemise = pourcentageRemise;
    }

    public Float getTotalRemise() {
        return totalRemise;
    }

    public void setTotalRemise(Float totalRemise) {
        this.totalRemise = totalRemise;
    }

    public Float getTotalCommande() {
        return totalCommande;
    }

    public void setTotalCommande(Float totalCommande) {
        this.totalCommande = totalCommande;
    }
}