package edu.ccrm.cli;

import edu.ccrm.service.ImportExportService;
import java.util.Scanner;

public class ImportCLI {
    public static void handle(Scanner sc){
        ImportExportService.importSampleData();
        System.out.println("Import complete (sample).");
    }
}
