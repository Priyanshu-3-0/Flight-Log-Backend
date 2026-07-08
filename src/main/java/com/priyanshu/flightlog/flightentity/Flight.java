package com.priyanshu.flightlog.flightentity;
import com.priyanshu.flightlog.gpsentity.GpsData;
import java.util.List;
import jakarta.persistence.OneToMany;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(
            mappedBy = "flight",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<GpsData> gpsData;

    private String filePath;
    private String storagePath;

    private String fileName;


    private LocalDateTime uploadTime;


    private Integer totalPoints;



    public Flight(){

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


    public LocalDateTime getUploadTime() {
        return uploadTime;
    }


    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }


    public Integer getTotalPoints() {
        return totalPoints;
    }


    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }


}