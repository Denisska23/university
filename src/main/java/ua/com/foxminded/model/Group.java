package ua.com.foxminded.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString(exclude = {"lecture"})
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
