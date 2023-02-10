package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class FinalProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalProjectDemoApplication.class, args);
	}
	
	@GetMapping("/")
    public String hello() {
		String hostname;
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			hostname = "Unknown Host";
		}

		String html = 	"<html>" +
						"<body>" +
						"<h1>Demo SpringBoot Application</h1>" +
						"<p>This page was generated and deployed using Jenkins</p>" +
						"<p>Container hostname: " + hostname + "</p>" +
						"<p>Build: #%BUILD%</p>" +
						"<p>Build date: %DATE%</p>" +
						"</body>" +
						"</html>";

        return html;
    }

}