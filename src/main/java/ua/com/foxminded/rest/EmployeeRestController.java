package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Employee;
import ua.com.foxminded.service.EmployeeService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid @NotNull Employee employee) {
        Employee savedEmployee = employeeService.add(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable @NotNull Integer id) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid @NotNull Employee employee) {
        Employee updatedEmployee = employeeService.update(employee);
        if (updatedEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Employee> deleteEmployee(@RequestBody @NotNull Employee employee) {
        employeeService.remove(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
