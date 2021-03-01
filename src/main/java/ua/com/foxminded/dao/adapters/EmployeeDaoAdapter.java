package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.EmployeeDAO;
import ua.com.foxminded.dao.EmployeeRepo;
import ua.com.foxminded.model.Employee;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoAdapter implements EmployeeDAO {

    private final EmployeeRepo repository;

    @Override
    public Employee add(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public void remove(Employee employee) {
        repository.delete(employee);
    }
}
