package com.sece.greenlog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
public class Tree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String species;

    private String location;

    private LocalDate datePlanted;

    @ManyToOne
    @JoinColumn(name = "plantation_drive_id")
    private PlantationDrive plantationDrive;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(LocalDate datePlanted) {
        this.datePlanted = datePlanted;
    }

    public PlantationDrive getPlantationDrive() {
        return plantationDrive;
    }

    public void setPlantationDrive(PlantationDrive plantationDrive) {
        this.plantationDrive = plantationDrive;
    }
}