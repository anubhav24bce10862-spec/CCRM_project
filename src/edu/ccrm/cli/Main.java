package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.util.ExtraExamples;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AppConfig cfg = AppConfig.getInstance();
        // Demonstration of arrays, recursion, etc.
        ExtraExamples.demonstrate();

        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.println("=== CCRM Menu ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("3. Enrollments & Grades");
            System.out.println("4. Import Data");
            System.out.println("5. Export Data & Backup");
            System.out.println("6. Reports");
            System.out.println("7. Exit");
            System.out.print("> ");
            String choice = sc.nextLine().trim();
            switch(choice){
                case "1": StudentCLI.handle(sc); break;
                case "2": CourseCLI.handle(sc); break;
                case "3": EnrollmentCLI.handle(sc); break;
                case "4": ImportCLI.handle(sc); break;
                case "5": ExportCLI.handle(sc); break;
                case "6": ReportsCLI.handle(sc); break;
                case "7": run = false; break;
                default: System.out.println("Invalid choice");
            }
        }
        sc.close();
        System.out.println("Exiting CCRM.");
    }
}
