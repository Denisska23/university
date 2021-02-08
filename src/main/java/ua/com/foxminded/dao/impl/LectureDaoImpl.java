package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ua.com.foxminded.dao.LectureDAO;
import ua.com.foxminded.model.Lecture;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LectureDaoImpl implements LectureDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Lecture add(Lecture lecture) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(lecture);
        return getById(id);
    }

    @Override
    public Lecture getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Lecture.class, id);
    }

    @Override
    public List<Lecture> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Lecture").list();
    }

    @Override
    public Lecture update(Lecture lecture) {
        sessionFactory.getCurrentSession().update(lecture);
        return getById(lecture.getId());
    }

    @Override
    public void remove(Lecture lecture) {
        sessionFactory.getCurrentSession().delete(lecture);
    }
}
