package ua.com.foxminded.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.com.foxminded.enums.Position;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = {"idCard"})
@Entity
@Table(name = "employees")
public class Employee extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_card_id")
    private IdCard idCard;
    
    @Enumerated(EnumType.STRING)
    private Position position;
}
