package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.StudentDAO;
import ua.com.foxminded.dao.StudentRepo;
import ua.com.foxminded.model.Student;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDaoAdapter implements StudentDAO {

    private final StudentRepo repository;

    @Override
    public Student add(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student update(Student student) {
        return repository.save(student);
    }

    @Override
    public void remove(Student student) {
        repository.delete(student);
    }
}
