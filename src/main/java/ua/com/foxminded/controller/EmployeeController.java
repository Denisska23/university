package ua.com.foxminded.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Employee;
import ua.com.foxminded.service.EmployeeService;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee/getAll";
    }

    @GetMapping("/new")
    public String newEmployeeForm(@ModelAttribute("employee") Employee employee) {
        return "employee/new";
    }

    @PostMapping
    public String addEmployeeToDb(@ModelAttribute("employee") Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String editEmployeeForm(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee/edit";
    }

    @PostMapping("/{id}")
    public String updateEmployeeInDb(@ModelAttribute("employee") Employee employee) {
        employeeService.update(employee);
        return "redirect:/employees";
    }

    @PostMapping("/{id}/delete")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.remove(employeeService.getById(id));
        return "redirect:/employees";
    }
}
