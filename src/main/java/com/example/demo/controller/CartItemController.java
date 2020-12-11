package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.AppUser;
import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Products;
import com.example.demo.service.appUser.IAppUserService;
import com.example.demo.service.cartItem.ICartItemService;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cartitem")
public class CartItemController {
   @Autowired
   private ICartItemService cartItemService;
   @Autowired
   private IAppUserService appUserService;
   @Autowired
   private IProductService productService;
   @ModelAttribute()
   public AppUser currentUser(){
       return appUserService.getCurrentUser();
   }
    @GetMapping("/create/{id}")
    public ResponseEntity<CartItem> addCart(@PathVariable Long id) throws NotFoundException {
        Products products= productService.findById(id).get();
        Cart cart = currentUser().getCart();
        CartItem cartItem= new CartItem();
        cartItem.setProducts(products);
        cartItem.setCart(cart);
        cartItem.setQuantity(1);
        cartItemService.save(cartItem);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
