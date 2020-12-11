package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Products;
import com.example.demo.model.TradeMark;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import com.example.demo.service.trademark.ITrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShopController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ITrademarkService trademarkService;

    @ModelAttribute("category")
    public Iterable<Category> categories(@PageableDefault(size = 3) Pageable pageable) {
        return categoryService.findAll(pageable);
    }

    @ModelAttribute("trademark")
    public Iterable<TradeMark> tradeMarks( ) {
        return trademarkService.findAll();
    }

    @RequestMapping("")
    public ModelAndView index(@PageableDefault(size = 7) Pageable pageable) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("shop/index");
        Page<TradeMark> tradeMarks = trademarkService.findAll(pageable);
        TradeMark tradeMark1 = trademarkService.findById(1L).get();
        Iterable<Products> tradeProduct = productService.findAllByTradeMark(tradeMark1);
        Iterable<Products> newProduct = productService.findAllBy8Day();
        modelAndView.addObject("newProduct",newProduct);
        modelAndView.addObject("tradeMarks",tradeMarks);
        modelAndView.addObject("tradeProduct",tradeProduct);
        return modelAndView;
    }

    @RequestMapping("/details/{id}")
    public ModelAndView getDetails(@PathVariable Long id, @PageableDefault(size = 4) Pageable pageable) throws NotFoundException {
        ModelAndView modelAndView = new ModelAndView("shop/details");
        Products product = productService.findById(id).get();
        Category category = product.getCategory();
        Iterable<Products> products = productService.findAllByCategory(category,pageable);
        modelAndView.addObject("product",product);
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @RequestMapping("/test")
    public ModelAndView getTest() {
        ModelAndView modelAndView = new ModelAndView("shop/test");
        return modelAndView;
    }

    @RequestMapping("/getPrTrademark/{id}")
    public ResponseEntity<Iterable<Products>> getProductsWithApi(@PathVariable Long id) throws NotFoundException {
        TradeMark tradeMark = trademarkService.findById(id).get();
        Iterable<Products> products = productService.findAllByTradeMark(tradeMark);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
