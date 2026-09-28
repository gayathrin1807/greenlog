package com.sece.greenlog.controller;

import com.sece.greenlog.entity.CheckIn;
import com.sece.greenlog.service.CheckInService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkins")
public class CheckInController {

    private final CheckInService service;

    public CheckInController(CheckInService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CheckIn> createCheckIn(
            @Valid @RequestBody CheckIn checkIn) {

        return ResponseEntity.ok(service.createCheckIn(checkIn));
    }

    @GetMapping
    public ResponseEntity<List<CheckIn>> getAllCheckIns() {
        return ResponseEntity.ok(service.getAllCheckIns());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckIn> getCheckInById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getCheckInById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCheckIn(
            @PathVariable Long id) {

        service.deleteCheckIn(id);

        return ResponseEntity.ok("Check-in deleted successfully");
    }
}