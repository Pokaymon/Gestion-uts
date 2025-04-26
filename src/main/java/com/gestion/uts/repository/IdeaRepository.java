package com.gestion.uts.repository;

import com.gestion.uts.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface IdeaRepository extends MongoRepository<Idea, String> {
    Optional<Idea> findByTitulo(String titulo);
}

