package com.example.demo.service.product;

import com.example.demo.model.Category;
import com.example.demo.model.Products;
import com.example.demo.model.TradeMark;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Products> findAllByNameContaining(String name, Pageable pageable) {
        return productRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Iterable<Products> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Products> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Products> findAllByTradeMark(TradeMark tradeMark, Pageable pageable) {
        return productRepository.findAllByTradeMark(tradeMark,pageable);
    }

    @Override
    public Page<Products> findAllByCategory(Category category, Pageable pageable) {
        return productRepository.findAllByCategory(category,pageable);
    }

    @Override
    public Page<Products> findAllByNameContainingAndCategory(String name, Category category, Pageable pageable) {
        return productRepository.findAllByNameContainingAndCategory(name,category,pageable);
    }

    @Override
    public Page<Products> findAllByNameContainingAndTradeMark(String name, TradeMark tradeMark, Pageable pageable) {
        return productRepository.findAllByNameContainingAndTradeMark(name,tradeMark,pageable);
    }

    @Override
    public Page<Products> findAllByCategoryAndTradeMark(Category category, TradeMark tradeMark, Pageable pageable) {
        return productRepository.findAllByCategoryAndTradeMark(category,tradeMark,pageable);
    }

    @Override
    public Page<Products> findAllByNameContainingAndTradeMarkAndCategory(String name, Category category, TradeMark tradeMark, Pageable pageable) {
        return productRepository.findAllByNameContainingAndTradeMarkAndCategory(name,category,tradeMark,pageable);
    }

    @Override
    public Iterable<Products> findAllBy8Day() {
        return productRepository.findAllBy8Day();
    }

    @Override
    public Iterable<Products> findAllByTradeMark(TradeMark tradeMark) {
        return productRepository.findAllByTradeMark(tradeMark);
    }

    @Override
    public Iterable<Products> findAllByPriceBetween(Double min, Double max) {
        return productRepository.findAllByPriceBetween(min,max);
    }

    @Override
    public Optional<Products> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Products save(Products products) {
        return productRepository.save(products);
    }

}
