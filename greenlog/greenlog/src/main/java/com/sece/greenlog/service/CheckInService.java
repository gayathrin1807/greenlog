package com.sece.greenlog.service;

import com.sece.greenlog.entity.CheckIn;
import com.sece.greenlog.entity.Tree;
import com.sece.greenlog.repository.CheckInRepository;
import com.sece.greenlog.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInService {

    private final CheckInRepository checkInRepository;
    private final TreeRepository treeRepository;

    public CheckInService(CheckInRepository checkInRepository,
                          TreeRepository treeRepository) {
        this.checkInRepository = checkInRepository;
        this.treeRepository = treeRepository;
    }

    public CheckIn createCheckIn(CheckIn checkIn) {

        Tree tree = treeRepository.findById(checkIn.getTree().getId())
                .orElseThrow(() -> new RuntimeException("Tree not found"));

        // Check whether the tree was already marked dead
        List<CheckIn> previousCheckIns = checkInRepository.findAll();

        for (CheckIn previous : previousCheckIns) {
            if (previous.getTree().getId().equals(tree.getId())
                    && Boolean.FALSE.equals(previous.getAlive())) {

                throw new RuntimeException(
                        "Cannot create check-in. Tree is already marked dead."
                );
            }
        }

        checkIn.setTree(tree);

        return checkInRepository.save(checkIn);
    }

    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    public CheckIn getCheckInById(Long id) {
        return checkInRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Check-in not found"));
    }

    public void deleteCheckIn(Long id) {
        CheckIn checkIn = getCheckInById(id);
        checkInRepository.delete(checkIn);
    }
}