package com.priyanshu.flightlog.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "flight_logs")
public class flightlog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "file_name", nullable = false)
    private String fileName;


    @Column(name = "file_path")
    private String filePath;


    @Column(name = "cloud_url")
    private String cloudUrl;


    @Column(name = "upload_status")
    private String uploadStatus;


    @Column(name = "created_at")
    private LocalDateTime createdAt;



    public flightlog() {

    }



    public flightlog(Long id, String fileName, String filePath,
                     String cloudUrl, String uploadStatus,
                     LocalDateTime createdAt) {

        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.cloudUrl = cloudUrl;
        this.uploadStatus = uploadStatus;
        this.createdAt = createdAt;

    }



    @PrePersist
    public void onCreate() {

        this.createdAt = LocalDateTime.now();

    }



    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public String getFileName() {
        return fileName;
    }


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }



    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



    public String getCloudUrl() {
        return cloudUrl;
    }


    public void setCloudUrl(String cloudUrl) {
        this.cloudUrl = cloudUrl;
    }



    public String getUploadStatus() {
        return uploadStatus;
    }


    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}