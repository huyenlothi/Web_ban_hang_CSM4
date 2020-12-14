package com.example.demo.repository;

import com.example.demo.model.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
//    @Query(value = "select p.name, p.price, cart_item.quantity ,p.description, p.price*cart_item.quantity total from cart_item" +
//            "join products p on p.id = cart_item.product_id" +
//            "where c;")
}
