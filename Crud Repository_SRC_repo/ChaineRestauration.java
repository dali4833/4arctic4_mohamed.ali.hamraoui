package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode
public class ChaineRestauration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChaineRestauration;

    private String libelle;
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chaineRestauration", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants;


}

