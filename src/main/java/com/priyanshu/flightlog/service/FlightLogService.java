package com.priyanshu.flightlog.service;


import com.priyanshu.flightlog.dto.FlightLogResponseDTO;
import com.priyanshu.flightlog.dto.UploadResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FlightLogService {


    UploadResponseDTO uploadFlightLog(MultipartFile file);


    List<FlightLogResponseDTO> getAllFlightLogs();


    FlightLogResponseDTO getFlightLogById(Long id);

}