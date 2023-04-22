package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.taxes.TaxDTO;
import br.com.grupotsm.TSMMeta.DTO.taxes.TaxNewDTO;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.entities.Tax;
import br.com.grupotsm.TSMMeta.repositories.TaxRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxService {

    @Autowired
    private TaxRepository repository;

    public Page<TaxDTO> findAll(Pageable pageable) {
        Page<Tax> obj = repository.findAll(pageable);
        return obj.map(TaxDTO::new);
    }

    protected Tax find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Tax.class);
        });
    }

    protected List<Tax> findByStore(Store store) {

        return repository.findByStores(store);
    }
    protected Double sumTaxes(Store store) {

        return findByStore(store).stream().mapToDouble(t -> t.getPercentage()).sum();
    }
    public TaxDTO findDTO(Long id) {
        Tax obj = find(id);
        return new TaxDTO(obj);
    }

    public TaxDTO insert(TaxNewDTO dto) {
        Tax obj = TaxNewDTO.fromDto(dto);
        obj = repository.save(obj);

        return new TaxDTO(obj);
    }

/*    public TaxDTO update(Long id, TaxUpdateInfosDTO dto) {
        Tax obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new TaxDTO(obj);
    }

    private void fromDto(Tax obj, TaxUpdateInfosDTO dto) {
        obj.setName(dto.getName() != null? dto.getName():obj.getName());
        obj.setPosition(dto.getPosition() != null? dto.getPosition():obj.getPosition());
        obj.setSalary(dto.getSalary() != null? dto.getSalary():obj.getSalary());
        obj.setResignationDate(dto.getAdmissionDate() != null? dto.getAdmissionDate():obj.getResignationDate());
    }
*/
}
