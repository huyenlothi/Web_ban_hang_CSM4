package com.example.demo.controller;

import com.example.demo.exeption.NotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.TradeMark;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.trademark.TrademarkService;
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
@RequestMapping("/trademark")
public class TrademarkController {

    @Autowired
    TrademarkService trademarkService;

    @Autowired
    private Environment environment;

    @ExceptionHandler(NotFoundException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/error/index");
    }

    @GetMapping("/create")
    public ModelAndView getCreate() {
        ModelAndView modelAndView = new ModelAndView("trademark/create");
        modelAndView.addObject("trademark", new TradeMark());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView postCreate(@ModelAttribute TradeMark tradeMark){
        MultipartFile file = tradeMark.getImg();
        String image = file.getOriginalFilename();
        String fileUpload = environment.getProperty("upload.path").toString();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        TradeMark tradeMark1 = new TradeMark();
        tradeMark1.setName(tradeMark.getName());
        tradeMark1.setImage(image);
        trademarkService.save(tradeMark1);
        ModelAndView modelAndView = new ModelAndView("trademark/create");
        modelAndView.addObject("trademark", new TradeMark());
        modelAndView.addObject("message", "Thêm loại rượu mơi thành công !!!");
        return modelAndView;
    }
}
