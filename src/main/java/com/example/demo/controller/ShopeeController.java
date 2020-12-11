package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.Products;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/shop")
public class ShopeeController {
    @Autowired
    private IProductService productService;
     @GetMapping("/list")
    public ModelAndView listProduct(@RequestParam("s") Optional<String> s, @PageableDefault(size = 15) Pageable pageable){
         Page<Products> products;
         if (s.isPresent()){
             products = productService.findAllByNameContaining(s.get(),pageable);
         }else {
             products =productService.findAll(pageable);
         }
         ModelAndView modelAndView = new ModelAndView("shop/store");
         modelAndView.addObject("listproduct",products);
         return modelAndView;
     }

     @GetMapping("/detail/{id}")
    public ModelAndView product(@PathVariable Long id) throws NotFoundException {
         ModelAndView modelAndView = new ModelAndView("shop/details");
         Products products= productService.findById(id).get();
         modelAndView.addObject("product",products);
         return modelAndView;
     }
}

