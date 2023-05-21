package com.example.demo;

import com.example.demo.student.StudentController;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    StudentService studentService;

    @Autowired
    StudentController studentController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
        MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
        String student = "{\"name\": \"bob\", \"email\" : \"bob@domain000.com\" ,  \"dob\" : \"ah@gb.com\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/student/add")
                        .content(student)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(textPlainUtf8));
    }
}
