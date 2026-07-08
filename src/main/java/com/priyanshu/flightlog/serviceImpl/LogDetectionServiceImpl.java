package com.priyanshu.flightlog.serviceImpl;


import com.priyanshu.flightlog.service.LogDetectionService;
import org.springframework.stereotype.Service;


@Service
public class LogDetectionServiceImpl implements LogDetectionService {


    @Override
    public void checkForNewLogs() {


        System.out.println(
                "Checking ArduPilot log folder..."
        );


        // Later:
        // Detect new .BIN file
        // Upload automatically

    }

}