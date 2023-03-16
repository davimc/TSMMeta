package br.com.grupotsm.TSMMeta.repositories;

import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Long> {
}
