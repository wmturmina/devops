package br.com.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.prometheus.PrometheusMeterRegistry;

@RestController
public class MetricsController {

	@Autowired
	private PrometheusMeterRegistry prometheusMeterRegistry;
	
	@GetMapping("/metrics/prometheus")
	public ResponseEntity<String> metrics() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "text/plain; charset=utf-8");
		String body = prometheusMeterRegistry.scrape();
		return new ResponseEntity<String>(body, headers, HttpStatus.OK);
	}
	
}
