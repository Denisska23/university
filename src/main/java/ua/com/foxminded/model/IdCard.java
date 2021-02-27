package ua.com.foxminded.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "id_cards")
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Positive
    @NotNull
    private Integer number;

    @FutureOrPresent
    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "date_expire")
    private LocalDateTime dateExpire;
}
