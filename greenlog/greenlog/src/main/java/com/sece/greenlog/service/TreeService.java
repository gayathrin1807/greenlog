package com.sece.greenlog.service;

import com.sece.greenlog.entity.Tree;
import com.sece.greenlog.repository.TreeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeService {

    private final TreeRepository repository;

    public TreeService(TreeRepository repository) {
        this.repository = repository;
    }

    public Tree createTree(Tree tree) {
        return repository.save(tree);
    }

    public List<Tree> getAllTrees() {
        return repository.findAll();
    }

    public Tree getTreeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tree not found"));
    }

    public Tree updateTree(Long id, Tree tree) {
        Tree existing = getTreeById(id);

        existing.setSpecies(tree.getSpecies());
        existing.setLocation(tree.getLocation());
        existing.setDatePlanted(tree.getDatePlanted());
        existing.setPlantationDrive(tree.getPlantationDrive());

        return repository.save(existing);
    }

    public void deleteTree(Long id) {
        Tree existing = getTreeById(id);
        repository.delete(existing);
    }
}