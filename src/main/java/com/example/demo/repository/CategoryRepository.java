package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Products;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
