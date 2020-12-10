package com.example.demo.service.product;

import com.example.demo.model.Products;
import com.example.demo.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IService<Products> {
    Page<Products> findAllByNameContaining(String name, Pageable pageable);
    public Page<Products> findAll(Pageable pageable);
}
