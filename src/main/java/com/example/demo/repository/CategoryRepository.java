package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long>, CrudRepository<Category, Long> {
    Page<Category> findAllByNameContaining(String firstname, Pageable pageable);
}
