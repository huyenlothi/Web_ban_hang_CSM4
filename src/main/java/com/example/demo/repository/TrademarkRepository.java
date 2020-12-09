package com.example.demo.repository;

import com.example.demo.model.TradeMark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrademarkRepository extends PagingAndSortingRepository<TradeMark,Long>, CrudRepository<TradeMark, Long> {
    Page<TradeMark> findAllByNameContaining(String firstname, Pageable pageable);
}
