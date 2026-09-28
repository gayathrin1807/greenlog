package com.sece.greenlog.controller;

import com.sece.greenlog.entity.PlantationDrive;
import com.sece.greenlog.service.PlantationDriveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drives")
public class PlantationDriveController {

    private final PlantationDriveService service;

    public PlantationDriveController(PlantationDriveService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PlantationDrive> createDrive(
            @Valid @RequestBody PlantationDrive drive) {

        return ResponseEntity.ok(service.createDrive(drive));
    }

    @GetMapping
    public ResponseEntity<List<PlantationDrive>> getAllDrives() {
        return ResponseEntity.ok(service.getAllDrives());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantationDrive> getDriveById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getDriveById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlantationDrive> updateDrive(
            @PathVariable Long id,
            @Valid @RequestBody PlantationDrive drive) {

        return ResponseEntity.ok(service.updateDrive(id, drive));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrive(
            @PathVariable Long id) {

        service.deleteDrive(id);

        return ResponseEntity.ok("Plantation drive deleted successfully");
    }
}