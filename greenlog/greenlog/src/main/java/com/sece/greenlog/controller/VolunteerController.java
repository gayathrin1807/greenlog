package com.sece.greenlog.controller;

import com.sece.greenlog.entity.Volunteer;
import com.sece.greenlog.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Volunteer> createVolunteer(
            @Valid @RequestBody Volunteer volunteer) {

        return ResponseEntity.ok(service.createVolunteer(volunteer));
    }

    @GetMapping
    public ResponseEntity<List<Volunteer>> getAllVolunteers() {
        return ResponseEntity.ok(service.getAllVolunteers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Volunteer> getVolunteerById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getVolunteerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Volunteer> updateVolunteer(
            @PathVariable Long id,
            @Valid @RequestBody Volunteer volunteer) {

        return ResponseEntity.ok(service.updateVolunteer(id, volunteer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVolunteer(
            @PathVariable Long id) {

        service.deleteVolunteer(id);

        return ResponseEntity.ok("Volunteer deleted successfully");
    }
}