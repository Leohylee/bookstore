package com.leolee.bookstore.repository;

import com.leolee.bookstore.model.StockLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StockLevelRepository extends JpaRepository<StockLevel, Long> {
    // CRUD database methods

    @Query("SELECT s FROM StockLevel s JOIN s.book b WHERE b.id = :bookId")
    StockLevel findStockLevelByBook(long bookId);

    @Query("SELECT b.title, s.qty FROM StockLevel s JOIN s.book b WHERE b.id = :bookId")
    List<Object> findStockLevelByBookWithBookInfo(long bookId);

    @Modifying
    @Query("UPDATE StockLevel s SET s.qty = s.qty - :qty WHERE s.id IN (SELECT s1.id FROM StockLevel s1 JOIN s1.book b WHERE b.id = :bid)")
    void updateStockLevel(long bid, int qty);

    @Modifying
    @Query("UPDATE StockLevel s SET s.qty = :qty WHERE s.id = :id")
    void setStockLevel(long id, int qty);

}
