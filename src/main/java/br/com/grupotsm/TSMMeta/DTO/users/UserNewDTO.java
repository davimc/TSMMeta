package br.com.grupotsm.TSMMeta.DTO.users;

import br.com.grupotsm.TSMMeta.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserNewDTO {

    @NotNull(message = "nome é necessário")
    @Size(min = 2, max = 45, message = "tamanho mínimo 2 e máximo 45")
    private String name;

    @NotNull(message = "email é necessário")
    @Email(message = "formato de email incompatível")
    private String email;

    @NotNull(message = "password é necessário")
    @Size(min = 6, max = 20, message = "tamanho mínimo 8, máximo 20")
    private String password;

    public UserNewDTO() {
    }

    public UserNewDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UserNewDTO(User obj) {
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
