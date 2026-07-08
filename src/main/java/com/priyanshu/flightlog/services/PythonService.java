package com.priyanshu.flightlog.services;

import org.springframework.stereotype.Service;

import com.priyanshu.flightlog.utils.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import com.priyanshu.flightlog.repository.FlightRepository;

import org.springframework.scheduling.annotation.Async;

import com.priyanshu.flightlog.flightentity.Flight;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;


@Service
public class PythonService {
    @Autowired
    private JsonReader jsonReader;
    @Autowired
    private LocalStorageService localStorageService;

    @Autowired
    private FlightRepository flightRepository;

    @Async
    public void runParser(String binFilePath, Flight flight) {
        {

            try {

                ProcessBuilder processBuilder = new ProcessBuilder(
                        "python",
                        "D:\\FlightParser\\parser.py",
                        binFilePath
                );

                Process process = processBuilder.start();

                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(process.getInputStream()));

                String line;

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                process.waitFor();

                System.out.println("Python Finished");

                jsonReader.readJsonAndSave(flight);

                System.out.println("Starting local storage...");

                try {

                    String storagePath =
                            localStorageService.store(new File(binFilePath));

                    System.out.println("Storage completed: " + storagePath);

                    flight.setStoragePath(storagePath);

                    flight.setUploadStatus("SUCCESS");
                    flight.setFailureReason(null);

                }catch (Exception e) {

                        System.out.println("Storage Failed : " + e.getMessage());

                        flight.setUploadStatus("FAILED");

                        flight.setFailureReason(e.getMessage());
                    }

                flightRepository.save(flight);

                System.out.println("Data Imported into MySQL");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
