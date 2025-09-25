package edu.ccrm.cli;

import edu.ccrm.service.CourseService;
import java.util.Scanner;

public class CourseCLI {
    public static void handle(Scanner sc){
        CourseService service = CourseService.getInstance();
        System.out.println("--- Courses ---");
        System.out.println("1. List courses");
        System.out.println("2. Add sample course");
        System.out.println("3. Back");
        System.out.print("> ");
        String c = sc.nextLine().trim();
        switch(c){
            case "1": service.listAll().forEach(cou -> System.out.println(cou)); break;
            case "2": service.addSample(); System.out.println("Sample course added."); break;
            default: break;
        }
    }
}
