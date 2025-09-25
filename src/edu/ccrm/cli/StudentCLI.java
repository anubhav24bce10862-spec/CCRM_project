package edu.ccrm.cli;

import edu.ccrm.service.StudentService;
import java.util.Scanner;

public class StudentCLI {
    public static void handle(Scanner sc){
        StudentService service = StudentService.getInstance();
        System.out.println("--- Students ---");
        System.out.println("1. List students");
        System.out.println("2. Add sample student");
        System.out.println("3. Back");
        System.out.print("> ");
        String c = sc.nextLine().trim();
        switch(c){
            case "1": service.listAll().forEach(s -> System.out.println(s)); break;
            case "2": service.addSample(); System.out.println("Sample student added."); break;
            default: break;
        }
    }
}
