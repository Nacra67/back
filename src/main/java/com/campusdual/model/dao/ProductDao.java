package com.campusdual.model.dao;

import com.campusdual.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findByNameEquals(String name);
    List<Product> findByStockLessThan(Integer stock);
    List<Product> findByActiveIs(Boolean active);
}
