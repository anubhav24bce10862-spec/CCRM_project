package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseService {
    private static CourseService instance;
    private final List<Course> courses = new ArrayList<>();

    private CourseService(){}

    public static synchronized CourseService getInstance(){
        if(instance == null) instance = new CourseService();
        return instance;
    }

    public List<Course> listAll(){
        return Collections.unmodifiableList(courses);
    }

    public void addSample(){
        Course c = new Course.Builder("CS101", "Intro to Programming").credits(3).instructor("Dr. Ravi").semester(Semester.FALL).department("ComputerScience").build();
        courses.add(c);
    }
}
