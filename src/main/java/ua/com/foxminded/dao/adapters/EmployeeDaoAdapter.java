package ua.com.foxminded.dao.adapters;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foxminded.dao.EmployeeDAO;
import ua.com.foxminded.model.Employee;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDaoAdapter implements EmployeeDAO {

    private final JpaRepository<Employee, Integer> repository;

    @Override
    public Employee add(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee getById(Integer id) {
        return repository.getOne(id);
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
