package com.priyanshu.flightlog.services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WatcherStartup {

    @Autowired
    private FileWatcherService fileWatcherService;

    @PostConstruct
    public void start() {

        fileWatcherService.watchFolder();

    }
}