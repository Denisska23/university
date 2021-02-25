package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Course;

public interface CourseRepo extends JpaRepository<Course, String> {
}
