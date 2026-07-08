package com.priyanshu.flightlog.GpsRepository;

import com.priyanshu.flightlog.gpsentity.GpsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GpsRepository extends JpaRepository<GpsData, Long> {

    List<GpsData> findByFlightIdOrderByIdAsc(Long flightId);

}