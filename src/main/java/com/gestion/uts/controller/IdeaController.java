package com.gestion.uts.controller;

import com.gestion.uts.model.Idea;
import com.gestion.uts.service.IdeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ideas")
public class IdeaController {

    @Autowired
    private IdeaService ideaService;

    @GetMapping
    public List<Idea> getAllIdeas() {
        return ideaService.getAllIdeas();
    }

    @GetMapping("/{id}")
    public Optional<Idea> getIdeaById(@PathVariable String id) {
        return ideaService.getIdeaById(id);
    }

    @PostMapping
    public Idea createIdea(@RequestBody Idea idea) throws Exception {
        return ideaService.createIdea(idea);
    }

    @PutMapping("/{id}")
    public Idea updateIdea(@PathVariable String id, @RequestBody Idea ideaDetails) throws Exception {
        return ideaService.updateIdea(id, ideaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteIdea(@PathVariable String id) {
        ideaService.deleteIdea(id);
    }
}

