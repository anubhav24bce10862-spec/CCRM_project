package edu.ccrm.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public final class FileUtil {
    private FileUtil(){}

    public static long folderSize(Path path) throws IOException {
        try (Stream<Path> s = Files.walk(path)) {
            return s.filter(Files::isRegularFile).mapToLong(p -> {
                try { return Files.size(p); } catch (Exception e){ return 0L; }
            }).sum();
        }
    }
}
