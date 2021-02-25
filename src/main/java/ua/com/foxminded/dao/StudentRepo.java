package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
