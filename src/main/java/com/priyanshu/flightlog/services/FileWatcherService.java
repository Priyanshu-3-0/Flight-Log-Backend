package com.priyanshu.flightlog.services;
import com.priyanshu.flightlog.flightentity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.nio.file.*;


@Service
public class FileWatcherService {

    private static final String WATCH_FOLDER =
            "D:\\FlightParser\\mission_logs";

    @Autowired
    private PythonService pythonService;

    @Autowired
    private FileUploadServices fileUploadServices;


    @Async
    public void watchFolder() {

        try {

            WatchService watchService =
                    FileSystems.getDefault().newWatchService();

            Paths.get(WATCH_FOLDER)
                    .register(
                            watchService,
                            StandardWatchEventKinds.ENTRY_CREATE
                    );

            System.out.println("Watching folder: " + WATCH_FOLDER);

            while (true) {

                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {

                    Path file =
                            Paths.get(WATCH_FOLDER)
                                    .resolve((Path) event.context());

                    if (file.toString().endsWith(".BIN")) {

                        System.out.println(
                                "New BIN detected: " + file
                        );

                        Flight flight = fileUploadServices.createFlightFromExistingFile(file.toFile());

                        pythonService.runParser(file.toString(), flight);

                    }

                }

                key.reset();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}