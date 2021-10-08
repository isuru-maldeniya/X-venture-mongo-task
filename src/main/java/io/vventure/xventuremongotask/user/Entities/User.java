package io.vventure.xventuremongotask.user.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(value = "user")
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private LocalDate dob;

}
