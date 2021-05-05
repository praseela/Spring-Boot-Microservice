package com.demo.productservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.productservice.model.Product;
import com.demo.productservice.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ProductController", description = "REST Apis related to Customer Entity!!!!")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@ApiOperation(value = "Get list of Product in the System ", response = List.class)

	@GetMapping("/Product")
	public List<Product> getAllData() {
		List<Product> list = productService.findAll();
		return list;

	}

	@ApiOperation(value = "Create of Product in the System ", response = List.class)

	@PostMapping("/Product")
	public Product saveData(@RequestBody Product product) {
		Product data = productService.save(product);
		return data;
	}

	@ApiOperation(value = "Update Product in the System ", response = List.class)

	@PutMapping("/Product")
	public Product updateById(@RequestBody Product product) {
		Product data = productService.updateProduct(product);
		return data;

	}
	
	
	@ApiOperation(value = " Product by name in the System ", response = List.class)

	@GetMapping("/Product/{name}")
	public Optional<Product> getByName(@PathVariable("name") String name) {
		Optional<Product> data = productService.findByName(name);
		return data;

	}

	@ApiOperation(value = "Get Product in the System ", response = List.class)

	@GetMapping("/Products/{id}")
	public Optional<Product> getById(@PathVariable("id") int id) {
		Optional<Product> data = productService.findById(id);
		return data;

	}

	@ApiOperation(value = "Delete of Product in the System ", response = List.class)
	@DeleteMapping("/Product/{id}")
	public void deleteById(@PathVariable("id") int id) {
		productService.deleteById(id);

	}

}
