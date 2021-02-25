package ua.com.foxminded.dao.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.foxminded.dao.EmployeeDAO;
import ua.com.foxminded.model.Employee;

import java.util.List;


@RequiredArgsConstructor
public class EmployeeDaoImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Override
    public Employee add(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(employee);
        return getById(id);
    }

    @Override
    public Employee getById(Integer id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM Employee").list();
    }

    @Override
    public Employee update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return getById(employee.getId());
    }

    @Override
    public void remove(Employee employee) {
        sessionFactory.getCurrentSession().delete(employee);
    }
}
