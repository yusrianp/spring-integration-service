package com.example.demo.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "open-api-client", url = "${open-api-client.host}")
public interface OpenApiClient {

	@PostMapping(value = "/insert_employee", consumes = MediaType.APPLICATION_JSON_VALUE)
	Map<String, Object> insert(@RequestBody Map<String, Object> post);

	@GetMapping(value = "/employee/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	Map<String, Object> getById(@PathVariable("id") String id);

}
