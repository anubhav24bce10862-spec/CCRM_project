package edu.ccrm.cli;

import edu.ccrm.service.*;
import edu.ccrm.domain.*;
import edu.ccrm.exception.*;
import java.util.Scanner;

public class EnrollmentCLI {
    public static void handle(Scanner sc){
        StudentService ss = StudentService.getInstance();
        CourseService cs = CourseService.getInstance();
        EnrollmentService es = EnrollmentService.getInstance();

        System.out.println("--- Enrollments ---");
        System.out.println("1. Enroll first student in first course");
        System.out.println("2. Assign grade A to first student in first course");
        System.out.println("3. Show GPA of first student");
        System.out.print("> ");
        String c = sc.nextLine().trim();
        try{
            switch(c){
                case "1":
                    if(ss.listAll().isEmpty()) ss.addSample();
                    if(cs.listAll().isEmpty()) cs.addSample();
                    es.enroll(ss.listAll().get(0), cs.listAll().get(0));
                    System.out.println("Enrolled.");
                    break;
                case "2":
                    es.assignGrade(ss.listAll().get(0), cs.listAll().get(0), Grade.A);
                    System.out.println("Grade assigned.");
                    break;
                case "3":
                    double gpa = es.calculateGPA(ss.listAll().get(0));
                    System.out.println("GPA: " + gpa);
                    break;
                default: break;
            }
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
