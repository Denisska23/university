package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.StudentDAO;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.StudentService;

import java.util.List;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    @Override
    public Student add(Student student) {
        log.debug("method 'add' invoked with parameter '{}'", student);
        sanitize(student);
        log.debug("method 'add(Student entity)' result: '{}'", student);
        return studentDAO.add(student);
    }

    private void sanitize(Student student) {
        if (student == null) return;
        ofNullable(student.getCourse())
                .filter(course -> course.getId() == null && course.getName() == null)
                .ifPresent(c -> student.setCourse(null));
        ofNullable(student.getGroup())
                .filter(group -> group.getId() == null && group.getName() == null)
                .ifPresent(c -> student.setGroup(null));
    }

    @Override
    public Student getById(Integer id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        Student student = studentDAO.getById(id);
        log.debug("method 'getById(Integer id)' result: '{}'", student);
        return student;
    }

    @Override
    public List<Student> getAll() {
        log.debug("method 'getAll' invoked");
        List<Student> students = studentDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", students);
        return students;
    }

    @Override
    public Student update(Student entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        sanitize(entity);
        log.debug("method 'update(Student entity)' result: '{}'", entity);
        return studentDAO.update(entity);
    }

    @Override
    public void remove(Student entity) {
        log.debug("method 'remove' invoked with parameter '{}'", entity);
        studentDAO.remove(entity);
        log.debug("remove completed");
    }
}
