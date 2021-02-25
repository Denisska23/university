package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.CourseDAO;
import ua.com.foxminded.model.Course;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CourseDaoAdapter implements CourseDAO {

    private final JpaRepository<Course, String> repository;

    @Override
    public Course add(Course course) {
        return repository.save(course);
    }

    @Override
    public Course getById(String id) {
        return repository.getOne(id);
    }

    @Override
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    public Course update(Course course) {
        return repository.save(course);
    }

    @Override
    public void remove(Course course) {
        repository.delete(course);
    }
}
