package ua.com.foxminded.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.foxminded.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
