package io.vventure.xventuremongotask.user.DTO;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDTO {

    private String id;
    @NotBlank
    @Size(min = 2,max = 20)
//    @Min(value = 2, message = "the length is not enough")
//    @Max(value = 20,message = "the length is too high")
    private String name;
    private String email;
    private LocalDate dob;

    public UserDTO(String id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
