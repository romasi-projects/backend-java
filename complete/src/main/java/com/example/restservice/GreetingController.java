package com.example.restservice;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;


@RestController
public class GreetingController {

	private static final String template = "%s";

	@Autowired
	private ServerProperties serverProperties;

	@GetMapping("/")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws UnknownHostException {
		// InetAddress ip = InetAddress.getLocalHost();
		// int serverPort = serverProperties.getPort();	
		// return new Greeting(String.format(template, ip.getHostAddress() + ":" + String.valueOf(serverPort)));

		String address = System.getenv("ADDRESS");
		return new Greeting(String.format(template, address));
	}
}
