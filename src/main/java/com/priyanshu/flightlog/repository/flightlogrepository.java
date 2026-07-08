package com.priyanshu.flightlog.repository;


import com.priyanshu.flightlog.entity.flightlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface flightlogrepository extends JpaRepository<flightlog, Long> {

}