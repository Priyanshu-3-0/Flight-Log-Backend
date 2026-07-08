package com.priyanshu.flightlog.repository;


import com.priyanshu.flightlog.flightentity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight,Long>{

}