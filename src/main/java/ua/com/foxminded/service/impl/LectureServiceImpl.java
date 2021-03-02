package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.LectureDAO;
import ua.com.foxminded.exceptions.NotFoundException;
import ua.com.foxminded.exceptions.NotModifiedException;
import ua.com.foxminded.model.Lecture;
import ua.com.foxminded.service.LectureService;

import java.util.List;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    
    private final LectureDAO lectureDAO;

    @Override
    public Lecture add(Lecture entity) {
        log.debug("method 'add' invoked with parameter '{}'", entity);
        Lecture lecture = lectureDAO.add(entity);
        log.debug("method 'add(Lecture entity)' result: '{}'", lecture);
        return lecture;
    }

    @Override
    public Lecture getById(Integer id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        Lecture lecture = lectureDAO.getById(id);
        log.debug("method 'getById(Integer id)' result: '{}'", lecture);
        return ofNullable(lecture)
                .orElseThrow(() -> new NotFoundException(String.format("Lecture with id %s not found!", id)));
    }

    @Override
    public List<Lecture> getAll() {
        log.debug("method 'getAll' invoked");
        List<Lecture> lectures = lectureDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", lectures);
        return ofNullable(lectures)
                .orElseThrow(() -> new NotFoundException("List of lectures is empty!"));
    }

    @Override
    public Lecture update(Lecture entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        Lecture lecture = lectureDAO.update(entity);
        log.debug("method 'update(Lecture entity)' ressult: '{}'", lecture);
        return ofNullable(lecture)
                .orElseThrow(() -> new NotModifiedException("Lecture is not modified!"));
    }

    @Override
    public void remove(Lecture entity) {
        log.debug("method 'remove' invoked");
        lectureDAO.remove(entity);
        log.debug("remove completed");
    }
}
