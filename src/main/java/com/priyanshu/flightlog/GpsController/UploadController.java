package com.priyanshu.flightlog.GpsController;
import com.priyanshu.flightlog.flightentity.Flight;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.priyanshu.flightlog.services.FileUploadServices;
import com.priyanshu.flightlog.services.PythonService;
import org.springframework.http.MediaType;
@RestController
@RequestMapping("/api/upload")
@CrossOrigin("*")
public class UploadController {

    private final FileUploadServices fileUploadService;
    private final PythonService pythonService;


    public UploadController(FileUploadServices fileUploadService,
                            PythonService pythonService) {

        this.fileUploadService = fileUploadService;
        this.pythonService = pythonService;

    }

/*
    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file)
            throws Exception {


        String filePath = fileUploadService.saveFile(file);

        pythonService.runParser(filePath);


        return "File uploaded and processed successfully";

    }
*/
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam("file") MultipartFile file)
            throws Exception {
        Flight flight = fileUploadService.saveFile(file);

    /*pythonService.runParser(flight.getFilePath());*/
        pythonService.runParser(
                flight.getFilePath(),
                flight
    );

        return "File uploaded and processed successfully";

    }
}