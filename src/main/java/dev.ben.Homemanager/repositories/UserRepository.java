package dev.ben.Homemanager.repositories;


import dev.ben.Homemanager.database.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT COUNT(u) = 1 FROM User u WHERE u.email = ?1")
    boolean existsByEmail(String email);
}

