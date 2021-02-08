package ua.com.foxminded.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "system_info")
    private String name;
}
