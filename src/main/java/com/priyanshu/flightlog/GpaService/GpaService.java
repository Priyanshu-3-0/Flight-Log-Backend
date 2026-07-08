package com.priyanshu.flightlog.GpaService;

import com.priyanshu.flightlog.gpsentity.GpsData;
import com.priyanshu.flightlog.GpsRepository.GpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.priyanshu.flightlog.dto.FlightStatistics;
import com.priyanshu.flightlog.dto.FlightRoutePoint;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class GpaService {

    @Autowired
    private GpsRepository repository;

    public void saveAll(List<GpsData> gpsList) {
        repository.saveAll(gpsList);
    }

    public List<GpsData> getAllGpsData() {
        return repository.findAll();
    }
    public List<GpsData> getGpsDataByFlightId(Long flightId) {

        return repository.findByFlightIdOrderByIdAsc(flightId);

    }
    public FlightStatistics getFlightStatistics(Long flightId) {

        List<GpsData> gpsList = repository.findByFlightIdOrderByIdAsc(flightId);

        if (gpsList.isEmpty()) {
            return null;
        }

        FlightStatistics statistics = new FlightStatistics();

        statistics.setFlightId(flightId);
        statistics.setTotalPoints(gpsList.size());

        statistics.setMaxAltitude(
                gpsList.stream()
                        .map(GpsData::getAltitude)
                        .filter(a -> a != null)
                        .max(Double::compare)
                        .orElse(0.0)
        );

        statistics.setMinAltitude(
                gpsList.stream()
                        .map(GpsData::getAltitude)
                        .filter(a -> a != null)
                        .min(Double::compare)
                        .orElse(0.0)
        );

        statistics.setAverageAltitude(
                gpsList.stream()
                        .map(GpsData::getAltitude)
                        .filter(a -> a != null)
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0)
        );

        statistics.setMaxSpeed(
                gpsList.stream()
                        .map(GpsData::getSpeed)
                        .filter(s -> s != null)
                        .max(Double::compare)
                        .orElse(0.0)
        );

        statistics.setAverageSpeed(
                gpsList.stream()
                        .map(GpsData::getSpeed)
                        .filter(s -> s != null)
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0)
        );

        return statistics;
    }

    public List<FlightRoutePoint> getFlightRoute(Long flightId) {

        List<GpsData> gpsList =
                repository.findByFlightIdOrderByIdAsc(flightId);

        return gpsList.stream()
                .map(gps -> new FlightRoutePoint(
                        gps.getLatitude(),
                        gps.getLongitude(),
                        gps.getAltitude(),
                        gps.getSpeed()
                ))
                .collect(Collectors.toList());
    }
}