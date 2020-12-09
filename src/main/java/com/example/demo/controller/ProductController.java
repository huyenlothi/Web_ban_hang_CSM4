package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.Products;
import com.example.demo.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/")
    public ModelAndView getAll() {
        ModelAndView modelAndView= new ModelAndView("product/list");
        modelAndView.addObject("listProduct",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView= new ModelAndView("product/create");
        modelAndView.addObject("product",new Products());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Products products){
        ModelAndView modelAndView= new ModelAndView("product/create");
        productService.save(products);
        modelAndView.addObject("product",products);
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editproduct(@PathVariable Long id) throws NotFoundException {
        ModelAndView modelAndView= new ModelAndView("product/edit");
        Products products = productService.findById(id).get();
        modelAndView.addObject("product",products);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editProduct(@ModelAttribute Products products){
        ModelAndView modelAndView= new ModelAndView("product/edit");
        productService.save(products);
        modelAndView.addObject("product",products);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("product/delete");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("product/delete");
        productService.delete(id);
        modelAndView.addObject("product",new Products());
        return modelAndView;
    }
}
