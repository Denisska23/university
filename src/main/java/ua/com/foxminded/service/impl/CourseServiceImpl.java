package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.CourseDAO;
import ua.com.foxminded.exceptions.NotFoundException;
import ua.com.foxminded.exceptions.NotModifiedException;
import ua.com.foxminded.model.Course;
import ua.com.foxminded.service.CourseService;

import java.util.List;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;

    @Override
    public Course add(Course entity) {
        log.debug("method 'add' invoked with parameter '{}'", entity);
        Course course = courseDAO.add(entity);
        log.debug("method 'add(Course entity)' result: '{}'", course);
        return course;
    }

    @Override
    public Course getById(String id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        Course course = courseDAO.getById(id);
        log.debug("method 'getById(Course entity)' result: '{}'", course);
        return ofNullable(course)
                .orElseThrow(() -> new NotFoundException(String.format("Course with id %s not found!", id)));
    }

    @Override
    public List<Course> getAll() {
        log.debug("method 'getAll' invoked");
        List<Course> courseList = courseDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", courseList);
        return ofNullable(courseList)
                .orElseThrow(() -> new NotFoundException("List of courses is empty!"));
    }

    @Override
    public Course update(Course entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        Course course = courseDAO.update(entity);
        log.debug("method 'update(Course entity)' result: '{}'", course);
        return ofNullable(course)
                .orElseThrow(() -> new NotModifiedException("Course is not modified!"));
    }

    @Override
    public void remove(Course entity) {
        log.debug("method 'remove' invoked with parameter '{}'", entity);
        courseDAO.remove(entity);
        log.debug("method 'remove(Course entity)' complete");
    }
}
