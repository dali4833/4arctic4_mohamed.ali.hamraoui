package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor // Default constructor
 // Constructor with all attributes
 // For logging

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Component

@Table(name = "Restaurant")
public class Restaurant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurant")
    private Long idRestaurant; // Clé primaire

    private String nom; // Name of the restaurant
    private Long nbPlacesMax; // Maximum number of places
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Menu> menus = new HashSet<>(); // List of menus associated with this restaurant
    @ManyToOne
    @JoinColumn(name = "chaine_id", nullable = false) // Foreign key for ChaineRestauration
    private ChaineRestauration chaineRestauration; // Reference to the restaurant chain



    // Getters and Setters
    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getNbPlacesMax() {
        return nbPlacesMax;
    }

    public void setNbPlacesMax(Long nbPlacesMax) {
        this.nbPlacesMax = nbPlacesMax;
    }

    public ChaineRestauration getChaineRestauration() {
        return chaineRestauration;
    }

    public void setChaineRestauration(ChaineRestauration chaineRestauration) {
        this.chaineRestauration = chaineRestauration;
    }
}