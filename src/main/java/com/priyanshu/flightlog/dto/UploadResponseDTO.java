package com.priyanshu.flightlog.dto;


public class UploadResponseDTO {


    private Long id;

    private String message;

    private String fileName;

    private String uploadStatus;



    public UploadResponseDTO() {

    }



    public UploadResponseDTO(Long id, String message,
                             String fileName,
                             String uploadStatus) {

        this.id = id;
        this.message = message;
        this.fileName = fileName;
        this.uploadStatus = uploadStatus;

    }



    public Long getId() {
        return id;
    }


    public String getMessage() {
        return message;
    }


    public String getFileName() {
        return fileName;
    }


    public String getUploadStatus() {
        return uploadStatus;
    }

}