package com.springboot.pagination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	private Long id;
	private String name;
	private String description;
	private String category;
	private String brand;
	private Double ratings;
	private Integer stockQuantity;
	private Boolean isActive;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	public Integer getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(Integer stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public Product(Long id, String name, String description, String category, String brand, Double ratings,
			Integer stockQuantity, Boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.brand = brand;
		this.ratings = ratings;
		this.stockQuantity = stockQuantity;
		this.isActive = isActive;
	}
}
