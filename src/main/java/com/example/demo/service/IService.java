package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Optional;


public interface IService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void delete(Long id);
    T save(T t);
}
