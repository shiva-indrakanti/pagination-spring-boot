package com.springboot.pagination.repo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.springboot.pagination.entity.Product;

@Repository
public interface IPagination extends JpaRepository<Product, Long>,JpaSpecificationExecutor<Product>{
	Page<Product> findAll(Specification<Product> spec,Pageable pageable);
}
