package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@Table(name = "ChefCuisinier")
public class ChefCuisinier implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idChefCuisinier")
    private Long idChefCuisinier; // Clé primaire

    private String nom; // Last name
    private String prenom; // First name
    @Enumerated(EnumType.STRING) // Storing enum as a string in the database
    private TypeChef typeChef; // Type of chef// Type of chef

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Chef_Menu",
            joinColumns = @JoinColumn(name = "chef_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private Set<Menu> menus = new HashSet<>(); // List of menus associated with this chef

    public ChefCuisinier(String nom, String prenom, TypeChef typeChef) {
        this.nom = nom;
        this.prenom = prenom;
        this.typeChef = typeChef;
    }

    // Getters and Setters
    public Long getIdChefCuisinier() {
        return idChefCuisinier;
    }

    public void setIdChefCuisinier(Long idChefCuisinier) {
        this.idChefCuisinier = idChefCuisinier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeChef getTypeChef() {
        return typeChef;
    }

    public void setTypeChef(TypeChef typeChef) {
        this.typeChef = typeChef;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}