package br.com.grupotsm.TSMMeta.repositories;

import br.com.grupotsm.TSMMeta.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
}
