package br.com.grupotsm.TSMMeta.services;

import br.com.grupotsm.TSMMeta.DTO.UserDTO;
import br.com.grupotsm.TSMMeta.DTO.UserNewDTO;
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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    public UserDTO find(Long id) {
        User obj = repository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException(id, User.class);
        });
        return new UserDTO(obj);
    }

    public UserDTO insert(UserNewDTO newDto) {
        User obj = fromDto(newDto);
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
}
