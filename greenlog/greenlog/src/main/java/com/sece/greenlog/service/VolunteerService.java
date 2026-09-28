package com.sece.greenlog.service;

import com.sece.greenlog.entity.Volunteer;
import com.sece.greenlog.repository.VolunteerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        return repository.save(volunteer);
    }

    public List<Volunteer> getAllVolunteers() {
        return repository.findAll();
    }

    public Volunteer getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }

    public Volunteer updateVolunteer(Long id, Volunteer volunteer) {
        Volunteer existing = getVolunteerById(id);

        existing.setName(volunteer.getName());
        existing.setEmail(volunteer.getEmail());
        existing.setTreesPlanted(volunteer.getTreesPlanted());

        return repository.save(existing);
    }

    public void deleteVolunteer(Long id) {
        Volunteer existing = getVolunteerById(id);
        repository.delete(existing);
    }
}