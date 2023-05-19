package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/age")
    public List<Integer> getStudentAge(){
        return studentService.getStudentAge();
    }

    @PostMapping(value = "/search")
    public List<Student> searchStudent(@RequestBody StudentSearch search ){
        return studentService.searchStudent(search);
    }

    @PostMapping(value="/add")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
}
