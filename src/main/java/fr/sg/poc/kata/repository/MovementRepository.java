package fr.sg.poc.kata.repository;

import fr.sg.poc.kata.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {

    @Query(value = "SELECT * FROM movement m where m.id_compte = :idCompte", nativeQuery = true)
    List<Movement> historique(@Param("idCompte") Long idCompte);
}
