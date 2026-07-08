package com.priyanshu.flightlog.utils;

import com.priyanshu.flightlog.flightentity.Flight;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.priyanshu.flightlog.gpsentity.GpsData;
import com.priyanshu.flightlog.GpaService.GpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Component
public class JsonReader {


    @Autowired
    private GpaService gpaService;


/*
    public void readJsonAndSave() {


        try {


            ObjectMapper mapper = new ObjectMapper();


            File file = new File(
                    "D:\\FlightParser\\gps_data.json"
            );


            List<GpsData> gpsList = mapper.readValue(
                    file,
                    new TypeReference<List<GpsData>>() {}
            );


            gpaService.saveAll(gpsList);


            System.out.println(
                    "Saved "
                            + gpsList.size()
                            + " GPS records into MySQL."
            );


        }
        catch(IOException e){

            e.printStackTrace();

        }

    }
*/
public void readJsonAndSave(Flight flight) {

    try {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File(
                "D:\\FlightParser\\gps_data.json"
        );

        List<GpsData> gpsList = mapper.readValue(
                file,
                new TypeReference<List<GpsData>>() {}
        );

        for (GpsData gps : gpsList) {
            gps.setFlight(flight);
        }

        flight.setTotalPoints(gpsList.size());

        gpaService.saveAll(gpsList);

        System.out.println(
                "Saved "
                        + gpsList.size()
                        + " GPS records into MySQL."
        );

    } catch (IOException e) {

        e.printStackTrace();

    }

}
}