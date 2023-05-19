package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    List<Student> students= List.of(
            new Student("Maryam",12, LocalDate.now(),"jmorsali@gmail.com"),
            new Student("javad",42,LocalDate.now().plusYears(-5),"jj@bb.com")
    );
    public StudentController() {
    }

    @GetMapping
    public List<Student> getStudent(){
        return students;
    }

    @GetMapping(value = "/age")
    public List<Integer> getStudentAge(){
        return students.stream().map(student -> student.getAge()).toList();
    }

    @PostMapping(value = "/search")
    public List<Student> searchStudent( StudentSearch search ){
        return students.stream().filter(x-> x.getName().contains(search.getName()) ).toList();
    }
}
