package edu.ccrm.cli;

import edu.ccrm.service.EnrollmentService;
import java.util.*;
import java.util.stream.Collectors;

public class ReportsCLI {
    public static void handle(java.util.Scanner sc){
        EnrollmentService es = EnrollmentService.getInstance();
        List<Double> gpas = es.allGPAs();
        if(gpas.isEmpty()){
            System.out.println("No GPA data available.");
            return;
        }
        Map<Integer, Long> buckets = gpas.stream().collect(Collectors.groupingBy(g -> (int)Math.floor(g), Collectors.counting()));
        System.out.println("--- GPA Distribution ---");
        for(Map.Entry<Integer, Long> e : buckets.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
