package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.stores.StoreDTO;
import br.com.grupotsm.TSMMeta.DTO.stores.StoreNewDTO;
import br.com.grupotsm.TSMMeta.DTO.stores.StoreUpdateDTO;
import br.com.grupotsm.TSMMeta.DTO.stores.StoreWithTaxesDTO;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.entities.Tax;
import br.com.grupotsm.TSMMeta.repositories.StoreRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import br.com.grupotsm.TSMMeta.utils.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private TaxService taxService;


    public Page<StoreDTO> findAll(Pageable pageable) {
        Page<Store> obj = repository.findAll(pageable);
        return obj.map(StoreDTO::new);
    }

    protected Store find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Store.class);
        });
    }
    public StoreDTO findDTO(Long id) {
        Store obj = find(id);
        return new StoreDTO(obj);
    }

    public StoreDTO insert(StoreNewDTO dto) {
        Store obj = StoreNewDTO.fromDto(dto);
        obj = repository.save(obj);

        return new StoreDTO(obj);
    }


    public StoreDTO update(Long id, StoreUpdateDTO dto) {
        Store obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new StoreDTO(obj);
    }

    private void fromDto(Store obj, StoreUpdateDTO dto) {
        obj.setName(dto.getName() != null ? dto.getName() : obj.getName());
    }

    public StoreWithTaxesDTO addTaxes(Long id, List<Long> taxesId) {
        Store obj = find(id);
        Store finalObj = obj;
        obj.getTaxes().addAll(taxesId.stream().map(t-> {return taxService.addStore(t, finalObj);}).toList());
        obj = repository.save(obj);

        return new StoreWithTaxesDTO(obj);
    }
}