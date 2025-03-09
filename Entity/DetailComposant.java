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
@Table(name = "DetailComposant")
public class DetailComposant implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailComposant")
    private Long idDetailComposant; // Clé primaire

    private Float imc; // IMC value

    @Enumerated(EnumType.STRING) // Storing enum as a string in the database
    private TypeComposant typeComposant; // Type of the component

    @OneToOne
    @JoinColumn(name = "composant_id", nullable = false, unique = true) // Foreign key for Composant
    private Composant composant; // Reference to the associated Composant

    public DetailComposant(Float imc, TypeComposant typeComposant, Composant composant) {
        this.imc = imc;
        this.typeComposant = typeComposant;
        this.composant = composant;
    }

    // Getters and Setters
    public Long getIdDetailComposant() {
        return idDetailComposant;
    }

    public void setIdDetailComposant(Long idDetailComposant) {
        this.idDetailComposant = idDetailComposant;
    }

    public Float getImc() {
        return imc;
    }

    public void setImc(Float imc) {
        this.imc = imc;
    }

    public TypeComposant getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(TypeComposant typeComposant) {
        this.typeComposant = typeComposant;
    }

    public Composant getComposant() {
        return composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }
}