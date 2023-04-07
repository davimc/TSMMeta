package br.com.grupotsm.TSMMeta.repositories;

import br.com.grupotsm.TSMMeta.entities.Debit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DebitRepository extends JpaRepository<Debit, Long> {
//todo lembrar como declara query
    @Query("SELECT d FROM Debit d WHERE :storeId = d.store.id AND d.date BETWEEN :date AND :end")
    List<Debit> findByDateBetween(Long storeId, LocalDate date, LocalDate end);
}
