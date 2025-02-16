
package com.example.demo;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String libelleMenu;

    @Enumerated(EnumType.STRING)
    private TypeMenu typeMenu;

    private Float prixTotal;



    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu")
    private List<Commande> commandes;

    @OneToMany(mappedBy = "menu")
    private List<Composant> composants;
}
