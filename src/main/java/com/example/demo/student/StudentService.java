package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository iStudentRepository ) {
        this.repository = iStudentRepository;
    }

    public List<Integer> getStudentAge() {
       //return students.stream().map(student -> student.getAge()).toList();
        return repository.findAll().stream().map(student -> student.getAge()).toList();
    }


    public List<Student> searchStudent(StudentSearch search) {
      return  repository.SearchByName(search.name);
    }


    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public void addStudent(Student student) {
       var students= repository.findStudentByEmail(student.getEmail());
       if(students.isPresent() )
           throw new IllegalStateException("student email already has been taken");
        repository.save(student);
    }
}
