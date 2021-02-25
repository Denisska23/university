package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.dao.CourseDAO;
import ua.com.foxminded.model.Course;

import java.util.List;


@RequiredArgsConstructor
public class CourseDaoImpl implements CourseDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Course add(Course course) {
        Session session = sessionFactory.getCurrentSession();
        String id = (String) session.save(course);
        return getById(id);
    }

    @Override
    public Course getById(String id) {
        return sessionFactory.getCurrentSession().get(Course.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Course> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Course").list();
    }

    @Override
    public Course update(Course course) {
        sessionFactory.getCurrentSession().update(course);
        return getById(course.getId());
    }

    @Override
    public void remove(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }
}
