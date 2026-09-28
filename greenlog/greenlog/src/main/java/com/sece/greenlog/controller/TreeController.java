package com.sece.greenlog.controller;

import com.sece.greenlog.entity.Tree;
import com.sece.greenlog.service.TreeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeService service;

    public TreeController(TreeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tree> createTree(
            @Valid @RequestBody Tree tree) {

        return ResponseEntity.ok(service.createTree(tree));
    }

    @GetMapping
    public ResponseEntity<List<Tree>> getAllTrees() {
        return ResponseEntity.ok(service.getAllTrees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tree> getTreeById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getTreeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tree> updateTree(
            @PathVariable Long id,
            @Valid @RequestBody Tree tree) {

        return ResponseEntity.ok(service.updateTree(id, tree));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTree(
            @PathVariable Long id) {

        service.deleteTree(id);

        return ResponseEntity.ok("Tree deleted successfully");
    }
}