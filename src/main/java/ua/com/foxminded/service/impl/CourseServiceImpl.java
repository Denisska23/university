package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.CourseDAO;
import ua.com.foxminded.model.Course;
import ua.com.foxminded.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final CourseDAO courseDAO;

    @Override
    @Transactional
    public Course add(Course entity) {
        LOGGER.debug("method 'add' invoked with parameter '{}'", entity);
        Course course = courseDAO.add(entity);
        LOGGER.debug("method 'add(Course entity)' result: '{}'", course);
        return course;
    }

    @Override
    @Transactional
    public Course getById(String id) {
        LOGGER.debug("method 'getById' invoked with parameter '{}'", id);
        Course course = courseDAO.getById(id);
        LOGGER.debug("method 'getById(Course entity)' result: '{}'", course);
        return course;
    }

    @Override
    @Transactional
    public List<Course> getAll() {
        LOGGER.debug("method 'getAll' invoked");
        List<Course> courseList = courseDAO.getAll();
        LOGGER.debug("method 'getAll()' result: '{}'", courseList);
        return courseList;
    }

    @Override
    @Transactional
    public Course update(Course entity) {
        LOGGER.debug("method 'update' invoked with parameter '{}'", entity);
        Course course = courseDAO.update(entity);
        LOGGER.debug("method 'update(Course entity)' result: '{}'", course);
        return course;
    }

    @Override
    @Transactional
    public void remove(Course entity) {
        LOGGER.debug("method 'remove' invoked with parameter '{}'", entity);
        courseDAO.remove(entity);
        LOGGER.debug("method 'remove(Course entity)' complete");
    }
}
