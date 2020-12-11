package com.example.demo.controller;

import com.example.demo.model.CartItem;
import com.example.demo.service.cartItem.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cartitem")
public class CartItemController {
   @Autowired
   private ICartItemService cartItemService;
    @PostMapping("/create")
    public ResponseEntity<CartItem> addCart(@RequestBody CartItem cartItem){
        cartItemService.save(cartItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
