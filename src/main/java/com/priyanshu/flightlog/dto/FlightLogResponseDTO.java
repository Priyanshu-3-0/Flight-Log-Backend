package com.priyanshu.flightlog.dto;

import java.time.LocalDateTime;


public class FlightLogResponseDTO {


    private Long id;

    private String fileName;

    private String filePath;

    private String cloudUrl;

    private String uploadStatus;

    private LocalDateTime createdAt;



    public FlightLogResponseDTO() {

    }



    public FlightLogResponseDTO(Long id, String fileName,
                                String filePath,
                                String cloudUrl,
                                String uploadStatus,
                                LocalDateTime createdAt) {

        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.cloudUrl = cloudUrl;
        this.uploadStatus = uploadStatus;
        this.createdAt = createdAt;

    }



    public Long getId() {
        return id;
    }


    public String getFileName() {
        return fileName;
    }


    public String getFilePath() {
        return filePath;
    }


    public String getCloudUrl() {
        return cloudUrl;
    }


    public String getUploadStatus() {
        return uploadStatus;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

}