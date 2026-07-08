package com.priyanshu.flightlog.serviceImpl;

import com.priyanshu.flightlog.exception.FileUploadException;
import com.priyanshu.flightlog.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import com.priyanshu.flightlog.flightentity.Flight;

@Service
public class FileUploadServiceImpl implements FileUploadService {


    private final String uploadDirectory = "flight-logs/";


    @Override
    public String uploadFile(MultipartFile file) {

        try {

            Path directoryPath = Paths.get(uploadDirectory);


            if (!Files.exists(directoryPath)) {
                Files.createDirectories(directoryPath);
            }


            String fileName = file.getOriginalFilename();

            if (fileName == null || fileName.isBlank()) {
                throw new FileUploadException("Uploaded file has no filename.");
            }

            Path filePath = directoryPath.resolve(fileName);


            Files.copy(
                    file.getInputStream(),
                    filePath,
                    StandardCopyOption.REPLACE_EXISTING
            );


            return filePath.toString();


        } catch (IOException e) {

            throw new FileUploadException(
                    "Failed to upload flight log file"
            );

        }
    }
}