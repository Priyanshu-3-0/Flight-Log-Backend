package com.priyanshu.flightlog.serviceImpl;


import com.priyanshu.flightlog.dto.FlightLogResponseDTO;
import com.priyanshu.flightlog.dto.UploadResponseDTO;
import com.priyanshu.flightlog.entity.flightlog;
import com.priyanshu.flightlog.repository.flightlogrepository;
import com.priyanshu.flightlog.service.FileUploadService;
import com.priyanshu.flightlog.service.FlightLogService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class FlightLogServiceImpl implements FlightLogService {


    private final flightlogrepository flightLogRepository;

    private final FileUploadService fileUploadService;



    public FlightLogServiceImpl(
            flightlogrepository flightLogRepository,
            FileUploadService fileUploadService
    ) {

        this.flightLogRepository = flightLogRepository;
        this.fileUploadService = fileUploadService;

    }



    @Override
    public UploadResponseDTO uploadFlightLog(MultipartFile file) {

        System.out.println("Original Filename: " + file.getOriginalFilename());
        System.out.println("File Size: " + file.getSize());
        System.out.println("Content Type: " + file.getContentType());
        System.out.println("Is Empty: " + file.isEmpty());


        String filePath =
                fileUploadService.uploadFile(file);



        flightlog flightLog = new flightlog();


        flightLog.setFileName(
                file.getOriginalFilename()
        );


        flightLog.setFilePath(filePath);


        flightLog.setUploadStatus(
                "UPLOADED"
        );


        flightlog savedLog =
                flightLogRepository.save(flightLog);



        return new UploadResponseDTO(

                savedLog.getId(),

                "Flight log uploaded successfully",

                savedLog.getFileName(),

                savedLog.getUploadStatus()

        );

    }




    @Override
    public List<FlightLogResponseDTO> getAllFlightLogs() {


        return flightLogRepository
                .findAll()
                .stream()
                .map(log -> new FlightLogResponseDTO(

                        log.getId(),
                        log.getFileName(),
                        log.getFilePath(),
                        log.getCloudUrl(),
                        log.getUploadStatus(),
                        log.getCreatedAt()

                ))
                .toList();

    }




    @Override
    public FlightLogResponseDTO getFlightLogById(Long id) {


        flightlog log =
                flightLogRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Flight log not found"
                                )
                        );


        return new FlightLogResponseDTO(

                log.getId(),
                log.getFileName(),
                log.getFilePath(),
                log.getCloudUrl(),
                log.getUploadStatus(),
                log.getCreatedAt()

        );

    }

}
