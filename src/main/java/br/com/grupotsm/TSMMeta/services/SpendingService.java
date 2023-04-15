package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.taxes.TaxDTO;
import br.com.grupotsm.TSMMeta.DTO.taxes.TaxNewDTO;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.entities.Tax;
import br.com.grupotsm.TSMMeta.repositories.TaxRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import br.com.grupotsm.TSMMeta.utils.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SpendingService {

    @Autowired
    private TaxService taxService;
    @Autowired
    private DebitService debitService;
    public Double calculateExpenses(Store store, LocalDate date) {
        Double taxes = getTaxes(store);
        Double debits = getDebits(store,date);

        return getExpenses(debits, taxes);
    }

    private Double getTaxes(Store store) {
        return taxService.sumTaxes(store);
    }

    private Double getDebits(Store store, LocalDate date) {
        return debitService.sumDebits(store,date);
    }

    private Double getExpenses(Double debits, Double taxes) {
        return debits * taxes / (100.0 - taxes);
    }
}
