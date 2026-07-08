package com.priyanshu.flightlog.gpsentity;
import com.priyanshu.flightlog.flightentity.Flight;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GpsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;
    private Double longitude;
    private Double altitude;
    private Double speed;
    private Integer satellites;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public GpsData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getSatellites() {
        return satellites;
    }

    public Flight getFlight() {
        return flight;
    }


    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setSatellites(Integer satellites) {
        this.satellites = satellites;
    }
}