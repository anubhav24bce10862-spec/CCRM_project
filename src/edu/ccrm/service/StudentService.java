package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentService {
    private static StudentService instance;
    private final List<Student> students = new ArrayList<>();

    private StudentService(){}

    public static synchronized StudentService getInstance(){
        if(instance == null) instance = new StudentService();
        return instance;
    }

    public List<Student> listAll(){
        return Collections.unmodifiableList(students);
    }

    public void addSample(){
        Student s = new Student.Builder("1", "Anubhav Chauhan").email("anubhav@test.edu").regNo("REG2025001").build();
        students.add(s);
    }
}
