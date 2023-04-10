package br.com.grupotsm.TSMMeta.repositories;

import br.com.grupotsm.TSMMeta.entities.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
}
