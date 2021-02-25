package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Lecture;

public interface LectureRepo extends JpaRepository<Lecture, Integer> {
}
