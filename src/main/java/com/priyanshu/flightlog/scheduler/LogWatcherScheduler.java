package com.priyanshu.flightlog.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class LogWatcherScheduler {

    private static final String LOG_FOLDER =
            "\\\\wsl.localhost\\Ubuntu\\home\\priyanshu\\ardupilot\\logs";

    @Scheduled(fixedRate = 5000)
    public void checkLogsFolder() {

        File folder = new File(LOG_FOLDER);

        if (!folder.exists()) {
            System.out.println("Log folder not found!");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        System.out.println("========== Flight Logs ==========");

        for (File file : files) {

            if (file.getName().toLowerCase().endsWith(".bin")) {

                System.out.println(file.getName());

            }

        }

        System.out.println("=================================");

    }
}