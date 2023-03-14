package br.com.grupotsm.TSMMeta.DTO;

import br.com.grupotsm.TSMMeta.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserUpdateDTO {

    @Size(min = 2, max = 45, message = "tamanho mínimo 2 e máximo 45")
    private String name;
    @Email(message = "formato de email incompatível")
    private String email;

    @Size(min = 6, max = 20, message = "tamanho mínimo 8, máximo 20")
    private String password;

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserUpdateDTO(User obj) {
        name = obj.getName();
        email = obj.getEmail();
        password = obj.getPassword();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
