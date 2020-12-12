package com.example.demo.repository;

import com.example.demo.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
