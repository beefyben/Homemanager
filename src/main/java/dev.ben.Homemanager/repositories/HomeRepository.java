package dev.ben.Homemanager.repositories;



import dev.ben.Homemanager.database.Home;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home, Long> {

    @Query("SELECT COUNT(home) = 1 FROM Home home WHERE home.homename = ?1")
    boolean existsByHomeName(String homename);
}

