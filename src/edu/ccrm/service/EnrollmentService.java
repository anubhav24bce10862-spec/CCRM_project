package edu.ccrm.service;

import edu.ccrm.domain.*;
import edu.ccrm.exception.*;
import java.util.*;

public class EnrollmentService {
    private static EnrollmentService instance;
    private final Map<String, Map<String, Grade>> enrollments = new HashMap<>(); // studentId -> (courseCode -> Grade)

    private EnrollmentService(){}

    public static synchronized EnrollmentService getInstance(){
        if(instance == null) instance = new EnrollmentService();
        return instance;
    }

    public void enroll(Student student, Course course) throws DuplicateEnrollmentException, MaxCreditLimitExceededException {
        Map<String, Grade> map = enrollments.computeIfAbsent(student.getId(), k -> new HashMap<>());
        if(map.containsKey(course.toString())){
            throw new DuplicateEnrollmentException("Already enrolled: " + student.getFullName() + " in " + course);
        }
        if(map.size() >= 6){
            throw new MaxCreditLimitExceededException("Student exceeded max 6 courses.");
        }
        map.put(course.toString(), null);
    }

    public void assignGrade(Student student, Course course, Grade grade){
        Map<String, Grade> map = enrollments.computeIfAbsent(student.getId(), k -> new HashMap<>());
        map.put(course.toString(), grade);
    }

    public Map<String, Grade> getEnrollments(Student student){
        return enrollments.getOrDefault(student.getId(), Collections.emptyMap());
    }

    public double calculateGPA(Student student){
        Map<String, Grade> map = enrollments.get(student.getId());
        if(map == null || map.isEmpty()) return 0.0;
        int totalPoints = 0, totalCourses = 0;
        for(Grade g : map.values()){
            if(g != null){
                totalPoints += g.getPoints();
                totalCourses++;
            }
        }
        return totalCourses == 0 ? 0.0 : (double) totalPoints / totalCourses;
    }

    public List<Double> allGPAs(){
        List<Double> list = new ArrayList<>();
        for(String sid : enrollments.keySet()){
            // simple calculation
            int totalPoints = 0, totalCourses = 0;
            for(Grade g : enrollments.get(sid).values()){
                if(g != null){
                    totalPoints += g.getPoints();
                    totalCourses++;
                }
            }
            if(totalCourses > 0) list.add((double) totalPoints / totalCourses);
        }
        return list;
    }
}
