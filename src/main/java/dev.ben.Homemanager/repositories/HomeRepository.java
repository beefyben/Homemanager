package dev.ben.Homemanager.repositories;



import dev.ben.Homemanager.database.Homes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface HomeRepository extends CrudRepository<Homes, Long> {

    @Query("SELECT COUNT(Homes) = 1 FROM Homes Homes WHERE Homes.homename = ?1")
    boolean existsByHomeName(String homename);
}

