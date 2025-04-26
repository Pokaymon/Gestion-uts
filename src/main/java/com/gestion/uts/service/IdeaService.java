package com.gestion.uts.service;

import com.gestion.uts.model.Idea;
import com.gestion.uts.repository.IdeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IdeaService {

    @Autowired
    private IdeaRepository ideaRepository;

    public List<Idea> getAllIdeas() {
        return ideaRepository.findAll();
    }

    public Optional<Idea> getIdeaById(String id) {
        return ideaRepository.findById(id);
    }

    public Idea createIdea(Idea idea) throws Exception {
        if (ideaRepository.findByTitulo(idea.getTitulo()).isPresent()) {
            throw new Exception("Ya existe una idea con este título.");
        }
        return ideaRepository.save(idea);
    }

    public Idea updateIdea(String id, Idea ideaDetails) throws Exception {
        Idea idea = ideaRepository.findById(id)
                .orElseThrow(() -> new Exception("Idea no encontrada con id: " + id));

        // Verificar si el nuevo título ya existe en otra idea
        Optional<Idea> existingIdea = ideaRepository.findByTitulo(ideaDetails.getTitulo());
        if (existingIdea.isPresent() && !existingIdea.get().getId().equals(id)) {
            throw new Exception("Ya existe otra idea con este título.");
        }

        idea.setTitulo(ideaDetails.getTitulo());
        idea.setDescripcion(ideaDetails.getDescripcion());
        idea.setTecnologias(ideaDetails.getTecnologias());
        idea.setFechaPropuesta(ideaDetails.getFechaPropuesta());
        idea.setObservaciones(ideaDetails.getObservaciones());

        return ideaRepository.save(idea);
    }

    public void deleteIdea(String id) {
        ideaRepository.deleteById(id);
    }
}

