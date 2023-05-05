package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.entities.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SpendingService {

    @Autowired
    private TaxService taxService;
    @Autowired
    private DebitService debitService;
    public Double calculateExpenses(Store store, LocalDate date) {
        List<Double> taxes = getTaxes(store);
        Double debits = getDebits(store,date);

        return getExpenses(debits, taxes);
    }

    private List<Double> getTaxes(Store store) {
        return taxService.sumTaxes(store);
    }

    private Double getDebits(Store store, LocalDate date) {
        return debitService.sumDebits(store,date);
    }

    private Double getExpenses(Double debits, List<Double> taxes) {
        return taxes.stream().reduce(debits,(subtotal, tax) -> (subtotal + ((subtotal * tax)/100-tax)));
        //return debits * taxees / (100.0 - taxes);
    }
}
