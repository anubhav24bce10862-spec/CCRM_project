package edu.ccrm.cli;

import edu.ccrm.service.ImportExportService;
import java.util.Scanner;

public class ExportCLI {
    public static void handle(Scanner sc){
        ImportExportService.createBackup();
        System.out.println("Export/Backup invoked.");
    }
}
