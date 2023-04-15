package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.debits.DebitDTO;
import br.com.grupotsm.TSMMeta.DTO.debits.DebitNewDTO;
import br.com.grupotsm.TSMMeta.entities.Debit;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.repositories.DebitRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import br.com.grupotsm.TSMMeta.utils.DateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DebitService {

    @Autowired
    private DebitRepository repository;

    public Page<DebitDTO> findAll(Pageable pageable) {
        Page<Debit> obj = repository.findAll(pageable);
        return obj.map(DebitDTO::new);
    }

    protected Debit find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Debit.class);
        });
    }
    public DebitDTO findDTO(Long id) {
        Debit obj = find(id);
        return new DebitDTO(obj);
    }

    protected Double debitsOfMonth(Store store, LocalDate first, LocalDate end) {
        List<Debit> obj = repository.findByDateBetween(store.getId(), first, end);
        Double total = 0.0;

        return obj.stream().mapToDouble(d -> d.getAmount()).sum();
    }
    protected Double sumDebits(Store store, LocalDate date) {
        LocalDate end = DateHandler.getLastDayOfMonth(date);
        date = DateHandler.getFirstDayOfMonth(date);

        return debitsOfMonth(store, date, end);
    }

    public DebitDTO insert(DebitNewDTO dto) {
        Debit obj = fromDto(dto);
        obj = repository.save(obj);

        return new DebitDTO(obj);
    }
    private Debit fromDto(DebitNewDTO dto) {
        Debit obj = new Debit();
        obj.setName(dto.getName());
        obj.setAmount(dto.getAmount());
        obj.setDate(dto.getDate());

        return obj;
    }
    /*

    public DebitDTO update(Long id, DebitUpdateDTO dto) {
        Debit obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new DebitDTO(obj);
    }

    private void fromDto(Debit obj, DebitUpdateDTO dto) {
        obj.setName(dto.getName() != null? dto.getName():obj.getName());
        obj.setEmail(dto.getEmail() != null? dto.getEmail() : obj.getEmail());
        obj.setPassword(dto.getPassword() != null? encoder.encode(dto.getPassword()):obj.getPassword());
    }*/
    }
