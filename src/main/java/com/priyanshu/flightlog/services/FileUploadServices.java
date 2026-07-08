/*package com.priyanshu.flightlog.services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServices {

    public String saveFile(MultipartFile file) throws IOException {

        String uploadDir = "D:\\FlightParser\\uploads";

        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = uploadDir + "\\" + file.getOriginalFilename();

        file.transferTo(new File(filePath));

        return filePath;
    }
}*/

package com.priyanshu.flightlog.services;

import com.priyanshu.flightlog.flightentity.Flight;
import com.priyanshu.flightlog.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class FileUploadServices {

    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFile(MultipartFile file) throws IOException {

        String uploadDir = "D:\\FlightParser\\uploads";

        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String filePath = uploadDir + "\\" + file.getOriginalFilename();

        file.transferTo(new File(filePath));

        Flight flight = new Flight();

        flight.setFileName(file.getOriginalFilename());
        flight.setFilePath(filePath);
        flight.setUploadTime(LocalDateTime.now());
        flight.setTotalPoints(0);
        flight.setUploadStatus("PROCESSING");

        return flightRepository.save(flight);
    }
    public Flight createFlightFromExistingFile(File file) {

        Flight flight = new Flight();

        flight.setFileName(file.getName());
        flight.setFilePath(file.getAbsolutePath());
        flight.setUploadTime(LocalDateTime.now());
        flight.setTotalPoints(0);
        flight.setUploadStatus("PROCESSING");

        return flightRepository.save(flight);
    }
}