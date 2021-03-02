package ua.com.foxminded.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.foxminded.model.Student;
import ua.com.foxminded.service.StudentService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid @NotNull Student student) {
        Student savedStudent = studentService.add(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Student> getStudent(@PathVariable @NotNull Integer id) {
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody @Valid @NotNull Student student) {
        Student updatedStudent = studentService.update(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Student> deleteStudent(@RequestBody @NotNull Student student) {
        studentService.remove(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
