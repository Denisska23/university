package ua.com.foxminded.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
public abstract class Person {

    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "last_name")
    private String lastName;
}
