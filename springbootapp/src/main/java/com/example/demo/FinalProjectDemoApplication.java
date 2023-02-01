package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FinalProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectDemoApplication.class, args);
	}
	
	@GetMapping("/")
    public String hello() {
        return "SpringBoot Hello World! \nJenkins build #%BUILD% (%DATE%)";
    }

}