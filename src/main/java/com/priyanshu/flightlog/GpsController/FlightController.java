package com.priyanshu.flightlog.GpsController;

import com.priyanshu.flightlog.flightentity.Flight;
import com.priyanshu.flightlog.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.priyanshu.flightlog.GpaService.GpaService;
import com.priyanshu.flightlog.gpsentity.GpsData;
import java.util.List;
import com.priyanshu.flightlog.dto.FlightStatistics;
import com.priyanshu.flightlog.dto.FlightRoutePoint;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.io.File;
@RestController
@RequestMapping("/api/flights")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private GpaService gpaService;

    @GetMapping
    public List<Flight> getAllFlights() {

        return flightService.getAllFlights();

    }
    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {

        return flightService.getFlightById(id);

    }
    @GetMapping("/{id}/gps")
    public List<GpsData> getGpsDataByFlight(@PathVariable Long id) {

        return gpaService.getGpsDataByFlightId(id);

    }
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id) {

        flightService.deleteFlight(id);

        return "Flight deleted successfully";

    }
    @GetMapping("/{flightId}/statistics")
    public FlightStatistics getFlightStatistics(@PathVariable Long flightId) {

        return gpaService.getFlightStatistics(flightId);

    }
    @GetMapping("/{flightId}/route")
    public List<FlightRoutePoint> getFlightRoute(
            @PathVariable Long flightId) {

        return gpaService.getFlightRoute(flightId);

    }
    @GetMapping("/{id}/download")
    public ResponseEntity<Resource> downloadFlight(@PathVariable Long id) {

        Flight flight = flightService.getFlightById(id);

        File file = new File(flight.getStoragePath());

        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + file.getName() + "\""
                )
                .body(resource);

    }

}