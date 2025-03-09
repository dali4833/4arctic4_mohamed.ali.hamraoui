package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all attributes
@Slf4j // For logging

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Component
@Table(name = "Menu")
public class Menu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMenu")
    private Long idMenu; // Clé primaire
    private Float prixTotal;
    private String nom; // Name of the menu item
    private double prix;
    private String libelleMenu;// Price of the menu item
    @Enumerated(EnumType.STRING) // Storing enum as a string in the database
    private TypeMenu typeMenu;
    @ManyToMany(mappedBy = "menus")
    private Set<ChefCuisinier> chefs = new HashSet<>();
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Commande> commandes; // Liste des commandes associées
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false) // Foreign key for Restaurant
    private Restaurant restaurant; // Reference to the Restaurant
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Composant> composants = new HashSet<>(); // List of components associated with this menu
    // Constructors




}
