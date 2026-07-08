package com.priyanshu.flightlog.dto;

public class FlightStatistics {

    private Long flightId;
    private Integer totalPoints;

    private Double maxAltitude;
    private Double minAltitude;
    private Double averageAltitude;

    private Double maxSpeed;
    private Double averageSpeed;

    public FlightStatistics() {
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Double getMaxAltitude() {
        return maxAltitude;
    }

    public void setMaxAltitude(Double maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public Double getMinAltitude() {
        return minAltitude;
    }

    public void setMinAltitude(Double minAltitude) {
        this.minAltitude = minAltitude;
    }

    public Double getAverageAltitude() {
        return averageAltitude;
    }

    public void setAverageAltitude(Double averageAltitude) {
        this.averageAltitude = averageAltitude;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }
}