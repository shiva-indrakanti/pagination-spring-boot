package com.springboot.pagination.mapper;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.pagination.dto.ProductRequest;
import com.springboot.pagination.dto.ProductsResponse;
import com.springboot.pagination.entity.Product;

public class DtoMapper {
	
	public static List<ProductsResponse> productsResponseListDtoMapper(List<Product> products){
		return products.stream().map(DtoMapper::toResponse).collect(Collectors.toList());
	}
	
	public static List<Product> toEntityListDtoMapper(List<ProductRequest> requestList) {
        return requestList.stream().map(DtoMapper::toEntity).collect(Collectors.toList());
    }
	
	public static Product toEntity(ProductRequest dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setBrand(dto.getBrand());
        product.setRatings(dto.getRatings());
        product.setStockQuantity(dto.getStockQuantity());
        product.setIsActive(dto.getIsActive());
        return product;
    }
	
	public static ProductsResponse toResponse(Product product) {
		ProductsResponse response = new ProductsResponse();
		response.setBrand(product.getBrand());
		response.setCategory(product.getCategory());
		response.setDescription(product.getDescription());
		response.setIsActive(product.getIsActive());
		response.setName(product.getName());
		response.setRatings(product.getRatings());
		response.setStockQuantity(product.getStockQuantity());
        return response;
    }
}
