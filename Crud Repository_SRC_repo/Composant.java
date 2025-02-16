package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComposant;

    private String nomComposant;


    private Float prix;

    @ManyToOne
    @JoinColumn(name = "idmenu")
    private Menu menu;

    @OneToMany(mappedBy = "composant")
    private List<DetailComposant> detailComposants;
}

