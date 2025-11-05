package com.springboot.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pagination.dto.ProductsResponse;
import com.springboot.pagination.service.PaginationService;

@RestController
@RequestMapping("/api/products")
public class PaginationController {
	
	@Autowired
	private PaginationService service;
	 
	@GetMapping("/list")
	public ResponseEntity<List<ProductsResponse>> getProducts(){
		List<ProductsResponse> products = service.fetchAllProducts();
		return ResponseEntity.status(HttpStatus.OK).header("X-Total-Count", String.valueOf(products.size())).body(products);
	}
	
}
