package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.LectureDAO;
import ua.com.foxminded.model.Lecture;
import ua.com.foxminded.service.LectureService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LectureServiceImpl.class);

    private final LectureDAO lectureDAO;

    @Override
    @Transactional
    public Lecture add(Lecture entity) {
        LOGGER.debug("method 'add' invoked with parameter '{}'", entity);
        Lecture lecture = lectureDAO.add(entity);
        LOGGER.debug("method 'add(Lecture entity)' result: '{}'", lecture);
        return lecture;
    }

    @Override
    @Transactional
    public Lecture getById(Integer id) {
        LOGGER.debug("method 'getById' invoked with parameter '{}'", id);
        Lecture lecture = lectureDAO.getById(id);
        LOGGER.debug("method 'getById(Integer id)' result: '{}'", lecture);
        return lecture;
    }

    @Override
    @Transactional
    public List<Lecture> getAll() {
        LOGGER.debug("method 'getAll' invoked");
        List<Lecture> lectures = lectureDAO.getAll();
        LOGGER.debug("method 'getAll()' result: '{}'", lectures);
        return lectures;
    }

    @Override
    @Transactional
    public Lecture update(Lecture entity) {
        LOGGER.debug("method 'update' invoked with parameter '{}'", entity);
        Lecture lecture = lectureDAO.update(entity);
        LOGGER.debug("method 'update(Lecture entity)' ressult: '{}'", lecture);
        return lecture;
    }

    @Override
    @Transactional
    public void remove(Lecture entity) {
        LOGGER.debug("method 'remove' invoked");
        lectureDAO.remove(entity);
        LOGGER.debug("remove completed");
    }
}
