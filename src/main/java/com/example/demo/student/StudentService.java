package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class StudentService {
    private final IStudentRepository repository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository ) {
        this.repository = iStudentRepository;
    }

    List<Student> students= List.of(
            new Student("Maryam",12, LocalDate.now(),"jmorsali@gmail.com"),
            new Student("javad",42,LocalDate.now().plusYears(-5),"jj@bb.com")
    );

    public List<Integer> getStudentAge() {
       //return students.stream().map(student -> student.getAge()).toList();
        return repository.findAll().stream().map(student -> student.getAge()).toList();
    }

    public List<Student> searchStudent(StudentSearch search) {
       return students.stream().filter(x-> x.getName().contains(search.getName()) ).toList();
        //return repository.findAll(x-> x. ).toList();
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }
}
