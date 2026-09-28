package com.sece.greenlog.service;

import com.sece.greenlog.entity.PlantationDrive;
import com.sece.greenlog.repository.PlantationDriveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationDriveService {

    private final PlantationDriveRepository repository;

    public PlantationDriveService(PlantationDriveRepository repository) {
        this.repository = repository;
    }

    public PlantationDrive createDrive(PlantationDrive drive) {
        return repository.save(drive);
    }

    public List<PlantationDrive> getAllDrives() {
        return repository.findAll();
    }

    public PlantationDrive getDriveById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plantation drive not found"));
    }

    public PlantationDrive updateDrive(Long id, PlantationDrive drive) {
        PlantationDrive existing = getDriveById(id);

        existing.setName(drive.getName());
        existing.setLocation(drive.getLocation());
        existing.setDate(drive.getDate());

        return repository.save(existing);
    }

    public void deleteDrive(Long id) {
        PlantationDrive existing = getDriveById(id);
        repository.delete(existing);
    }
}