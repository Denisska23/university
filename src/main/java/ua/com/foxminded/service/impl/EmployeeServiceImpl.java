package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.foxminded.dao.EmployeeDAO;
import ua.com.foxminded.model.Employee;
import ua.com.foxminded.service.EmployeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public Employee add(Employee entity) {
        LOGGER.debug("method 'add' invoked with parameter '{}'", entity);
        Employee employee = employeeDAO.add(entity);
        LOGGER.debug("method 'add(Employee entity)' result: '{}'", employee);
        return employee;
    }

    @Override
    @Transactional
    public Employee getById(Integer id) {
        LOGGER.debug("method 'getById' invoked with parameter '{}'", id);
        Employee employee = employeeDAO.getById(id);
        LOGGER.debug("method 'getById(Integer id)' result: '{}'", employee);
        return employee;
    }

    @Override
    @Transactional
    public List<Employee> getAll() {
        LOGGER.debug("method 'getAll' invoked");
        List<Employee> employees = employeeDAO.getAll();
        LOGGER.debug("method 'getAll()' result: '{}'", employees);
        return employees;
    }

    @Override
    @Transactional
    public Employee update(Employee entity) {
        LOGGER.debug("method 'update' invoked with parameter '{}'", entity);
        Employee employee = employeeDAO.update(entity);
        LOGGER.debug("method 'update(Employee entity)' result: '{}'", employee);
        return employee;
    }

    @Override
    @Transactional
    public void remove(Employee entity) {
        LOGGER.debug("method 'remove' invoked with parameter '{}'", entity);
        employeeDAO.remove(entity);
        LOGGER.debug("method 'remove(Employee entity)' complete");
    }
}
