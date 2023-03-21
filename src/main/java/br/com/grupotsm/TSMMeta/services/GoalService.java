package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.goals.GoalDTO;
import br.com.grupotsm.TSMMeta.DTO.goals.GoalNewDTO;
import br.com.grupotsm.TSMMeta.entities.Goal;
import br.com.grupotsm.TSMMeta.repositories.GoalRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository repository;
    @Autowired
    private StoreService storeService;

    public Page<GoalDTO> findAll(Pageable pageable) {
        Page<Goal> obj = repository.findAll(pageable);
        return obj.map(GoalDTO::new);
    }

    protected Goal find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Goal.class);
        });
    }
    public GoalDTO findDTO(Long id) {
        Goal obj = find(id);
        return new GoalDTO(obj);
    }
    /* todo
        * pensar em como será concretizado esse cálculo
    public GoalDTO insert(GoalNewDTO dto) {
        Goal obj = fromDto(dto);
        obj = repository.save(obj);

        return new GoalDTO(obj);
    }
    private Goal fromDto(GoalNewDTO dto) {
        Goal obj = new Goal();
        obj.setDate(dto.getDate());
        obj.setStoreId(storeService.find(dto.getStoreId()));

        return obj;
    }

    public GoalDTO update(Long id, GoalUpdateDTO dto) {
        Goal obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new GoalDTO(obj);
    }

    private void fromDto(Goal obj, GoalUpdateDTO dto) {
        obj.setName(dto.getName() != null? dto.getName():obj.getName());
        obj.setEmail(dto.getEmail() != null? dto.getEmail() : obj.getEmail());
        obj.setPassword(dto.getPassword() != null? encoder.encode(dto.getPassword()):obj.getPassword());
    }*/
    }
