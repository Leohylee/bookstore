package com.leolee.bookstore.controller;

import com.leolee.bookstore.model.StockLevel;
import com.leolee.bookstore.repository.StockLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stocklevel")
public class StockLevelController {

    @Autowired
    private StockLevelRepository stockLevelRepository;

    @GetMapping("/all")
    public List<StockLevel> getAllStockLevel() {
        return stockLevelRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Object> getStockLevelByBookId(@PathVariable long id) {
        return (List<Object>) stockLevelRepository.findStockLevelByBookWithBookInfo(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity setStockLevel(@PathVariable long id, @RequestParam int qty) {
        stockLevelRepository.setStockLevel(id, qty);
        return ResponseEntity.ok("Stock quantity updated successfully!");
    }
}
