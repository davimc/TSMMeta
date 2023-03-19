package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeNewDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeResignationDTO;
import br.com.grupotsm.TSMMeta.DTO.employees.EmployeeUpdateInfosDTO;
import br.com.grupotsm.TSMMeta.entities.Employee;
import br.com.grupotsm.TSMMeta.entities.Store;
import br.com.grupotsm.TSMMeta.repositories.EmployeeRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private StoreService storeService;

    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> obj = repository.findAll(pageable);
        return obj.map(EmployeeDTO::new);
    }

    protected Employee find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, Employee.class);
        });
    }
    public EmployeeDTO findDTO(Long id) {
        Employee obj = find(id);
        return new EmployeeDTO(obj);
    }

    public EmployeeDTO insert(EmployeeNewDTO dto) {
        Employee obj = fromDto(dto);
        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }
    private Employee fromDto(EmployeeNewDTO dto) {
        Employee obj = new Employee();
        obj.setName(dto.getName());
        obj.setAdmissionDate(dto.getAdmissionDate());
        obj.setSalary(dto.getSalary());
        obj.setPosition(dto.getPosition());

        Store store = storeService.find(dto.getStoreId());
        obj.setOriginalStore(store);
        obj.setCurrentStore(store);

        return obj;
    }

    public EmployeeDTO update(Long id, EmployeeUpdateInfosDTO dto) {
        Employee obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }

    private void fromDto(Employee obj, EmployeeUpdateInfosDTO dto) {
        obj.setName(dto.getName() != null? dto.getName():obj.getName());
        obj.setPosition(dto.getPosition() != null? dto.getPosition():obj.getPosition());
        obj.setSalary(dto.getSalary() != null? dto.getSalary():obj.getSalary());
        obj.setResignationDate(dto.getAdmissionDate() != null? dto.getAdmissionDate():obj.getResignationDate());
    }

    public EmployeeDTO dismiss(Long id, EmployeeResignationDTO updateDto) {
        Employee obj = find(id);
        if(updateDto.getResignationDate().isBefore(obj.getAdmissionDate()))
            throw new IllegalArgumentException("Data de desligamento não pode ser inferior a data de contratação");
        obj.setResignationDate(updateDto.getResignationDate());
        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }
}
