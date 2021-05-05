package com.demo.edgeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.edgeService.model.Edge;

@RestController
@RequestMapping("/")
public class EdgeController {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		return "Hello from Edge Service running at port: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/{id}")
	public Edge getGallery(@PathVariable final int id) {
		System.out.println("ID" + id);
		Edge edge = new Edge();
		edge.setId(id);

		// get list of available images
		List<Object> images = restTemplate.getForObject("http://ItemService/images/", List.class);
		edge.setImages(images);

		return edge;
	}

	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Item service running at port: " + env.getProperty("local.server.port");
	}
}
