package com.springboot.pagination.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.pagination.entity.Product;

@Repository
public interface IPagination extends JpaRepository<Product, Long>{

}
