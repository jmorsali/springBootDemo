package com.example.demo.student;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<String> addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.ok("student added");
    }

    @DeleteMapping(value="/{studentId}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("student deleted");
    }

    @PutMapping(value="/{studentId}/update")
    public ResponseEntity<String> updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student){
        studentService.updateStudent(studentId,student);
        return ResponseEntity.ok("student updated");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
