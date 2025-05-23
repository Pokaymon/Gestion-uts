package com.gestion.uts.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.gestion.uts.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByCedula(String cedula);
    boolean existsByCedula(String cedula);
}
