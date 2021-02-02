package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ua.com.foxminded.dao.StudentDAO;
import ua.com.foxminded.model.Student;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDaoImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Student add(Student student) {
        Session session = sessionFactory.getCurrentSession();
        student.setId((Integer) session.save(student));
        return student;
    }

    @Override
    public Student getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Student").list();
    }

    @Override
    public Student update(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return getById(student.getId());
    }

    @Override
    public void remove(Student student) {
        sessionFactory.getCurrentSession().delete(student);
    }
}
