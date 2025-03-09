package com.example.demo.Entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;


@NoArgsConstructor // Default constructor
@AllArgsConstructor // Constructor with all attributes
@Slf4j // For logging

@Data
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Composant")
public class Composant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComposant")
    private Long idComposant; // Clé primaire
    private String nomComposant; // Name of the component
    private Float prix; // Price of the component

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false) // Foreign key for Menu
    private Menu menu; // Reference to the Menu

    public Composant(String nomComposant, Float prix, Menu menu) {
        this.nomComposant = nomComposant;
        this.prix = prix;
        this.menu = menu;
    }

    // Getters and Setters
    public Long getIdComposant() {
        return idComposant;
    }

    public void setIdComposant(Long idComposant) {
        this.idComposant = idComposant;
    }

    public String getNomComposant() {
        return nomComposant;
    }

    public void setNomComposant(String nomComposant) {
        this.nomComposant = nomComposant;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}


