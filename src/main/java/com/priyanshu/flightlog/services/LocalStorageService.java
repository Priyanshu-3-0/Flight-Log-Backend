package com.priyanshu.flightlog.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Service
public class LocalStorageService {

    private static final String STORAGE_FOLDER =
            "k:\\FlightParser\\storage";

    public String store(File sourceFile) throws IOException {

        File folder = new File(STORAGE_FOLDER);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        File destination =
                new File(folder, sourceFile.getName());

        Files.copy(
                sourceFile.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );

        return destination.getAbsolutePath();
    }

}