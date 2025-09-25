package edu.ccrm.service;

import edu.ccrm.config.AppConfig;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImportExportService {
    public static void importSampleData(){
        // Simple sample: copy CSVs from data/test-data into working folder or just notify.
        System.out.println("Importing sample data from data/test-data/ (no-op in starter)");
    }

    public static void createBackup(){
        Path src = AppConfig.getInstance().getDataFolder().resolve("test-data");
        Path backups = AppConfig.getInstance().getDataFolder().resolve("backups");
        try {
            Files.createDirectories(backups);
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path dest = backups.resolve("backup_" + ts);
            Files.createDirectories(dest);
            if(Files.exists(src)){
                Files.walk(src).forEach(p -> {
                    try {
                        Path r = dest.resolve(src.relativize(p));
                        if(Files.isDirectory(p)) Files.createDirectories(r);
                        else Files.copy(p, r, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e){
                        System.err.println("Copy error: " + e.getMessage());
                    }
                });
                System.out.println("Backup created at: " + dest.toAbsolutePath());
            } else {
                System.out.println("No sample data found to backup at: " + src.toAbsolutePath());
            }
        } catch (IOException e){
            System.err.println("Backup failed: " + e.getMessage());
        }
    }
}
