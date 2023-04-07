package br.com.grupotsm.TSMMeta.repositories;

import br.com.grupotsm.TSMMeta.entities.Debit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class DebitRepositoryTest {

    @Autowired
    private DebitRepository repository;

    private Long totalDebitsFrom1LStore = 3L;

    @Test
    public void findByDateBetweenShouldReturnDebits() {
        List<Debit> debits = repository.findByDateBetween(1L, LocalDate.of(2023,03,01), LocalDate.of(2023,03,31));

        Assertions.assertTrue(debits.get(0).getName().equalsIgnoreCase("Aluguel"));
        Assertions.assertEquals(totalDebitsFrom1LStore, debits.size());
    }

}
