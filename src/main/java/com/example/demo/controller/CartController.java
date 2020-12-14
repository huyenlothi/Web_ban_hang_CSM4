package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.model.CartItem;
import com.example.demo.service.appUser.IAppUserService;
import com.example.demo.service.cart.ICartService;
import com.example.demo.service.cartItem.ICartItemService;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @Autowired
    private IAppUserService appUserService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ICartItemService cartItemService;

    @ModelAttribute()
    public AppUser currentUser(){
        return appUserService.getCurrentUser();
    }

    @PostMapping("create/cart/{id}")
    public ResponseEntity<CartItem> postCart(@PathVariable Long id) {
        AppUser user = currentUser();
        CartItem cartItem = new CartItem();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
