package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.UserDTO;
import br.com.grupotsm.TSMMeta.DTO.UserNewDTO;
import br.com.grupotsm.TSMMeta.DTO.UserUpdateDTO;
import br.com.grupotsm.TSMMeta.entities.User;
import br.com.grupotsm.TSMMeta.repositories.UserRepository;
import br.com.grupotsm.TSMMeta.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository repository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not founded"));
    }

    public Page<UserDTO> findAll(Pageable pageable) {
        Page<User> obj = repository.findAll(pageable);
        return obj.map(UserDTO::new);
    }

    protected User find(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, User.class);
        });
    }
    public UserDTO findDTO(Long id) {
        User obj = find(id);
        return new UserDTO(obj);
    }

    public UserDTO insert(UserNewDTO dto) {
        User obj = fromDto(dto);
        obj = repository.save(obj);

        return new UserDTO(obj);
    }

    public UserDTO update(Long id, UserUpdateDTO dto) {
        User obj = find(id);
        fromDto(obj, dto);
        obj = repository.save(obj);

        return new UserDTO(obj);
    }
    private User fromDto(UserNewDTO dto) {
        User obj = new User();
        obj.setName(dto.getName());
        obj.setEmail(dto.getEmail());
        obj.setPassword(encoder.encode(dto.getPassword()));

        return obj;
    }
    private void fromDto(User obj, UserUpdateDTO dto) {
        obj.setName(dto.getName() != null? dto.getName():obj.getName());
        obj.setEmail(dto.getEmail() != null? dto.getEmail() : obj.getEmail());
        obj.setPassword(dto.getPassword() != null? encoder.encode(dto.getPassword()):obj.getPassword());
    }

}
