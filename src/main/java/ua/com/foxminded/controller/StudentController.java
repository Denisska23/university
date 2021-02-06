package ua.com.foxminded.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.CourseService;
import ua.com.foxminded.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;

    @GetMapping
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return "student/getAll";
    }

    @GetMapping("/new")
    public String newStudentForm(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "student/new";
    }

    @PostMapping
    public String addStudentToDb(@ModelAttribute("student") Student student) {
        studentService.add(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        model.addAttribute("courses", courseService.getAll());
        return "student/edit";
    }

    @PostMapping("/{id}")
    public String updateStudentInDb(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.remove(studentService.getById(id));
        return "redirect:/students";
    }
}
