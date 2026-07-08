/*package com.priyanshu.flightlog;

import com.priyanshu.flightlog.services.PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FlightLogBackendApplication {

	@Autowired
	private PythonService pythonService;

	public static void main(String[] args) {
		SpringApplication.run(FlightLogBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			pythonService.runParser("D:\\FlightParser\\00000001.BIN");
		};
	}
}*/

package com.priyanshu.flightlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FlightLogBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightLogBackendApplication.class, args);
	}

}