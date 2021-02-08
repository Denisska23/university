package ua.com.foxminded.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "id_cards")
public class IdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    @Column(name = "date_expire")
    private LocalDateTime dateExpire;
}
