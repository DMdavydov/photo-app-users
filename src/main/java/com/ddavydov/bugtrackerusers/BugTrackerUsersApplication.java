package com.ddavydov.bugtrackerusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BugTrackerUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugTrackerUsersApplication.class, args);
    }

}
