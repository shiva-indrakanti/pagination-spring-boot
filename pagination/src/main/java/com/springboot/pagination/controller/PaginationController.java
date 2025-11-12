package com.springboot.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pagination.dto.ProductRequest;
import com.springboot.pagination.dto.ProductsResponse;
import com.springboot.pagination.service.PaginationService;

@RestController
@RequestMapping("/api/products")
public class PaginationController {
	
	@Autowired
	private PaginationService service;
	
	@PostMapping("/bulk")
	public ResponseEntity<List<ProductsResponse>> saveProducts(@RequestBody List<ProductRequest> request){
		List<ProductsResponse> products = service.saveAllProducts(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(products);
	}
	 
	@GetMapping("/list")
	public ResponseEntity<List<ProductsResponse>> getProducts(){
		List<ProductsResponse> products = service.fetchAllProducts();
		return ResponseEntity.status(HttpStatus.OK).header("Products-Total-Count", String.valueOf(products.size())).body(products);
	}
	
	@GetMapping("/list/custom/search")
	public ResponseEntity<List<ProductsResponse>> getProductsPerPage(@RequestParam(defaultValue = "1") int pageNo,
			                                                         @RequestParam(defaultValue = "5") int pageSize,
			                                                         @RequestParam(defaultValue = "id") String sortBy,
                                                                     @RequestParam(defaultValue = "ASC") String sortDir,
                                                                     @RequestParam(defaultValue="") String name,
                                                                     @RequestParam(defaultValue="") String category){
		List<ProductsResponse> products = service.fetchProducts(pageNo - 1,pageSize,sortBy,sortDir,name,category);
		return ResponseEntity.status(HttpStatus.OK).header("Products-Total-Count", String.valueOf(products.size())).body(products);
	}
}
