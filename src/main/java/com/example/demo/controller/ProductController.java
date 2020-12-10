package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Products;
import com.example.demo.model.TradeMark;
import com.example.demo.service.category.ICategoryService;
import com.example.demo.service.product.IProductService;
import com.example.demo.service.trademark.ITrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @Autowired
    ITrademarkService trademarkService;

    @Autowired
    private Environment environment;

    @ModelAttribute("category")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @ModelAttribute("trademark")
    public Iterable<TradeMark> tradeMarks() {
        return trademarkService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView getCreate() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product",new Products());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView postCreate(@ModelAttribute Products product) {
        MultipartFile file1 = product.getProductImage1();
        MultipartFile file2 = product.getProductImage2();
        MultipartFile file3 = product.getProductImage3();
        MultipartFile file4 = product.getProductImage4();
        String image1 = file1.getOriginalFilename();
        String image2 = file2.getOriginalFilename();
        String image3 = file3.getOriginalFilename();
        String image4 = file4.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(file1.getBytes(), new File(fileUpload + image1));
            FileCopyUtils.copy(file2.getBytes(), new File(fileUpload + image2));
            FileCopyUtils.copy(file3.getBytes(), new File(fileUpload + image3));
            FileCopyUtils.copy(file4.getBytes(), new File(fileUpload + image4));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Products products = new Products();
        products.setName(product.getName());
        products.setPrice(product.getPrice());
        products.setQuantity(product.getQuantity());
        products.setImage1(image1);
        products.setImage2(image2);
        products.setImage3(image3);
        products.setImage4(image4);
        products.setDescription(product.getDescription());
        products.setCategory(product.getCategory());
        products.setTradeMark(product.getTradeMark());
        productService.save(products);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Products());
        modelAndView.addObject("message", "Thêm sản phẩm mới thành công !!!");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView getUpdate(@PathVariable Long id) throws NotFoundException {
        Products product = productService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("product/update");
        modelAndView.addObject("product",product);
        return modelAndView;
    }
}
