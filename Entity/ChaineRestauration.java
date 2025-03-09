    package com.example.demo.Entity;
    import jakarta.persistence.*;
    import lombok.*;
    import lombok.extern.slf4j.Slf4j;

    import java.io.Serializable;
    import java.time.LocalDate;
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
    @Table(name = "ChaineRestauration")
    public class ChaineRestauration implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "idChaineRestauration")
        private Long idChaineRestauration; // Clé primaire

        private String libelle; // Name of the restaurant chain
        private LocalDate dateCreation; // Creation date of the chain

        @OneToMany(mappedBy = "chaineRestauration", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Restaurant> restaurants = new HashSet<>(); // List of restaurants in this chain

        public ChaineRestauration(String libelle, LocalDate dateCreation) {
            this.libelle = libelle;
            this.dateCreation = dateCreation;
        }

        // Getters and Setters
        public Long getIdChaineRestauration() {
            return idChaineRestauration;
        }

        public void setIdChaineRestauration(Long idChaineRestauration) {
            this.idChaineRestauration = idChaineRestauration;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public LocalDate getDateCreation() {
            return dateCreation;
        }

        public void setDateCreation(LocalDate dateCreation) {
            this.dateCreation = dateCreation;
        }

        public Set<Restaurant> getRestaurants() {
            return restaurants;
        }

        public void setRestaurants(Set<Restaurant> restaurants) {
            this.restaurants = restaurants;
        }

        public void addRestaurant(Restaurant restaurant) {
            this.restaurants.add(restaurant);
            restaurant.setChaineRestauration(this); // Maintain bidirectional relationship
        }

        public void removeRestaurant(Restaurant restaurant) {
            this.restaurants.remove(restaurant);
            restaurant.setChaineRestauration(null); // Maintain bidirectional relationship
        }
    }

