package com.priyanshu.flightlog.controller;

import com.priyanshu.flightlog.dto.FlightLogResponseDTO;
import com.priyanshu.flightlog.dto.UploadResponseDTO;
import com.priyanshu.flightlog.service.FlightLogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;



@RestController
@RequestMapping("/api/logs")
@CrossOrigin("*")
public class FlightLogController {



    private final FlightLogService flightLogService;



    public FlightLogController(FlightLogService flightLogService) {

        this.flightLogService = flightLogService;

    }




    // Upload Flight Log File
    @PostMapping("/upload")
    public ResponseEntity<UploadResponseDTO> uploadLog(
            @RequestParam("file") MultipartFile file
    ) {


        UploadResponseDTO response =
                flightLogService.uploadFlightLog(file);


        return new ResponseEntity<>(
                response,
                HttpStatus.CREATED
        );

    }





    // Get All Flight Logs
    @GetMapping
    public ResponseEntity<List<FlightLogResponseDTO>> getAllLogs() {


        List<FlightLogResponseDTO> logs =
                flightLogService.getAllFlightLogs();


        return ResponseEntity.ok(logs);

    }





    // Get Flight Log By ID
    @GetMapping("/{id}")
    public ResponseEntity<FlightLogResponseDTO> getLogById(
            @PathVariable Long id
    ) {


        FlightLogResponseDTO log =
                flightLogService.getFlightLogById(id);


        return ResponseEntity.ok(log);

    }


}