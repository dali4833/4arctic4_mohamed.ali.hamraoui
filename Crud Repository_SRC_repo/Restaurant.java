package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all attributes
@Slf4j // For logging
@Entity
@Data // Generates getters, setters, toString, equals, and hashCode
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;

    private String nom;
    private Long nbPlacesMax;

    @ManyToOne
    @JoinColumn(name = "idChaineRestauration")
    private ChaineRestauration chaineRestauration;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus;
}