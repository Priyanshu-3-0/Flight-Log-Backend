package com.priyanshu.flightlog.GpsController;


import com.priyanshu.flightlog.gpsentity.GpsData;
import com.priyanshu.flightlog.GpaService.GpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gps")
public class GpsController {

    @Autowired
    private GpaService gpsService;

    @GetMapping
    public List<GpsData> getAllGpsData() {
        return gpsService.getAllGpsData();
    }
}