package com.springboot.pagination.mapper;

import java.util.ArrayList;
import java.util.List;

import com.springboot.pagination.dto.ProductsResponse;
import com.springboot.pagination.entity.Product;

public class DtoMapper {
	public static List<ProductsResponse> productsListDtoMapper(List<Product> products){
		List<ProductsResponse> dtoResponse =  new ArrayList<>();
		for(Product product: products) {
			ProductsResponse response  = new ProductsResponse();
			response.setBrand(product.getBrand());
			response.setCategory(product.getCategory());
			response.setDescription(product.getDescription());
			response.setIsActive(product.getIsActive());
			response.setName(product.getName());
			response.setRatings(product.getRatings());
			response.setStockQuantity(product.getStockQuantity());
			dtoResponse.add(response);
		}
		return dtoResponse;
	}
}
