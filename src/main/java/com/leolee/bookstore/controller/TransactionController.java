package com.leolee.bookstore.controller;

import com.leolee.bookstore.model.Book;
import com.leolee.bookstore.model.StockLevel;
import com.leolee.bookstore.model.Transaction;
import com.leolee.bookstore.repository.BookRepository;
import com.leolee.bookstore.repository.StockLevelRepository;
import com.leolee.bookstore.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private StockLevelRepository stockLevelRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PutMapping
    public ResponseEntity purchase(@RequestBody List<Map<String, Object>> orders) {
        List<Transaction> transactions = new ArrayList<>();
        Map<Long, Integer> stocksUpdates = new HashMap<>();
        for (Map<String, Object> order : orders) {
            long bookId = (long) (int) order.get("bookId");
            Book book = bookRepository.getReferenceById(bookId);
            StockLevel stockLevel = stockLevelRepository.findStockLevelByBook(bookId);
            int qty = Optional.ofNullable((int) order.get("qty")).orElse(1);
            if (Objects.nonNull(stockLevel) && stockLevel.getQty() >= qty) {
                String customer = Optional.ofNullable((String) order.get("customerName")).orElse("Unknown");
                transactions.add(new Transaction(customer, book, qty));
                stocksUpdates.put(bookId, qty);
            } else {
                return ResponseEntity.ok(String.format("Sorry, Book (Id: %d) is out of stock / having insufficient stocks, purchase unsuccessful!", bookId));
            }
        }
        for (Map.Entry<Long, Integer> entry : stocksUpdates.entrySet()) {
            stockLevelRepository.updateStockLevel(entry.getKey(), entry.getValue());
        }
        transactionRepository.saveAll(transactions);
        return ResponseEntity.ok("Transactions made successfully! ");
    }

}
