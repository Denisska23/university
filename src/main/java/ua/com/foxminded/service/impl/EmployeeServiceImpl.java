package ua.com.foxminded.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.com.foxminded.dao.EmployeeDAO;
import ua.com.foxminded.model.Employee;
import ua.com.foxminded.service.EmployeeService;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Override
    public Employee add(Employee entity) {
        log.debug("method 'add' invoked with parameter '{}'", entity);
        Employee employee = employeeDAO.add(entity);
        log.debug("method 'add(Employee entity)' result: '{}'", employee);
        return employee;
    }

    @Override
    public Employee getById(Integer id) {
        log.debug("method 'getById' invoked with parameter '{}'", id);
        Employee employee = employeeDAO.getById(id);
        log.debug("method 'getById(Integer id)' result: '{}'", employee);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        log.debug("method 'getAll' invoked");
        List<Employee> employees = employeeDAO.getAll();
        log.debug("method 'getAll()' result: '{}'", employees);
        return employees;
    }

    @Override
    public Employee update(Employee entity) {
        log.debug("method 'update' invoked with parameter '{}'", entity);
        Employee employee = employeeDAO.update(entity);
        log.debug("method 'update(Employee entity)' result: '{}'", employee);
        return employee;
    }

    @Override
    public void remove(Employee entity) {
        log.debug("method 'remove' invoked with parameter '{}'", entity);
        employeeDAO.remove(entity);
        log.debug("method 'remove(Employee entity)' complete");
    }
}
