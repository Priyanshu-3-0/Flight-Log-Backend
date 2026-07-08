package com.priyanshu.flightlog.service;

import com.priyanshu.flightlog.flightentity.Flight;
import com.priyanshu.flightlog.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight createFlight(String fileName, int totalPoints) {

        Flight flight = new Flight();

        flight.setFileName(fileName);
        flight.setUploadTime(LocalDateTime.now());
        flight.setTotalPoints(totalPoints);

        return flightRepository.save(flight);
    }

    // NEW METHOD
    public List<Flight> getAllFlights() {

        return flightRepository.findAll();

    }

    public Flight getFlightById(Long id) {

        return flightRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Flight not found"));

    }
    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);

    }


}