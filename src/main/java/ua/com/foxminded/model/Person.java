package ua.com.foxminded.model;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class Person {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
