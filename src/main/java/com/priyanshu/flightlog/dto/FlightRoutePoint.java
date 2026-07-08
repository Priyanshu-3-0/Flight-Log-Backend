package com.priyanshu.flightlog.dto;

public class FlightRoutePoint {

    private Double latitude;
    private Double longitude;
    private Double altitude;
    private Double speed;

    public FlightRoutePoint() {
    }

    public FlightRoutePoint(Double latitude, Double longitude,
                            Double altitude, Double speed) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
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
}