package com.springboot.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.pagination.dto.ProductRequest;
import com.springboot.pagination.dto.ProductsResponse;
import com.springboot.pagination.entity.Product;
import com.springboot.pagination.mapper.DtoMapper;
import com.springboot.pagination.repo.IPagination;

@Service
public class PaginationService {
	
	@Autowired
	private IPagination iPagination;
	
	public List<ProductsResponse> fetchAllProducts(){
		List<Product> listOfProducts = iPagination.findAll();
		List<ProductsResponse> listOfProductDtos = DtoMapper.productsResponseListDtoMapper(listOfProducts);
		return listOfProductDtos;
	}

	public List<ProductsResponse> saveAllProducts(List<ProductRequest> request) {
		List<Product> listofProductsFromMapper = DtoMapper.toEntityListDtoMapper(request);
		iPagination.saveAll(listofProductsFromMapper);
		return DtoMapper.productsResponseListDtoMapper(listofProductsFromMapper);
	}
}
