package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;
import static java.time.Month.JUNE;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args->{
           var s1= new Student(1L,"Maryam", LocalDate.of(1982, JUNE,11),"jmorsali@gmail.com");
           var s2= new Student(2L,"javad",LocalDate.now().plusYears(-5),"jj@bb.com");
           studentRepository.saveAll(List.of(s1,s2));
        };
    }
}
