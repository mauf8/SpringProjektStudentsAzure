package com.example.deployspringprojectstudents.config;


import com.example.deployspringprojectstudents.model.Student;
import com.example.deployspringprojectstudents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    //s
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        // Laver student 1
        Student s1 = new Student();
        s1.setBornDate(LocalDate.now());
        s1.setName("Anne");
        s1.setBornTime(LocalTime.now());
        studentRepository.save(s1);

        System.out.println("saved");
        List<Student> lst = studentRepository.findAll();
        System.out.println("Antal studerende i database = " + lst.size());

        // Laver student 2
        Student s2 = new Student();
        s2.setBornDate(LocalDate.now().plusDays(1000));
        s2.setName("Viggo");
        studentRepository.save(s2);

        System.out.println("saved");
        lst = studentRepository.findAll();
        System.out.println("Antal studerende i database = " + lst.size());
    }
}

