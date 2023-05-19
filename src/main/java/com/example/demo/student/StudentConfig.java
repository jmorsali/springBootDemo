package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository studentRepository){
        return args->{
           var s1= new Student(1L,"Maryam",12, LocalDate.now(),"jmorsali@gmail.com");
           var s2= new Student(2L,"javad",42,LocalDate.now().plusYears(-5),"jj@bb.com");
           studentRepository.saveAll(List.of(s1,s2));
        };
    }
}
