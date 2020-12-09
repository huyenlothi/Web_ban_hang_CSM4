package com.example.demo.service.trademark;

import com.example.demo.model.TradeMark;
import com.example.demo.service.IService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITrademarkService extends IService<TradeMark> {
    Page<TradeMark> findAllByFirstNameContaining(String name, Pageable pageable);
    Page<TradeMark> findAll(Pageable pageable);
}
