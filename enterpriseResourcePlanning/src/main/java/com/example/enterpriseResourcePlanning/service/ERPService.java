package com.example.enterpriseResourcePlanning.service;

import com.example.enterpriseResourcePlanning.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ERPService {
    private static int RollNo = 0;
    private static final List<Student> students = new ArrayList<>();

    static {
        Student s1 = new Student(++RollNo, "Faisal Ali", 'M', List.of(75.0, 85.5, 98.8, 65.5, 73.3), "Gopalganj");
        students.add(s1);
        Student s2 = new Student(++RollNo, "Ramiz Raza", 'M', List.of(55.0, 76.5, 88.5, 65.5, 73.3), "Gopalganj");
        students.add(s2);
        Student s3 = new Student(++RollNo, "Parwez Alam", 'M', List.of(55.0, 75.0, 58.8, 63.0, 53.3), "Gopalganj");
        students.add(s3);
        Student s4 = new Student(++RollNo, "Arman Ali", 'M', List.of(53.0, 56.8, 63.4, 78.9, 74.6), "Gopalganj");
        students.add(s4);
        Student s5 = new Student(++RollNo, "Arif Raza", 'M', List.of(75.0, 85.5, 98.8, 65.5, 73.3), "Gopalganj");
        students.add(s5);
    }

    public List<Student> findAll() {
        return students;
    }
}
