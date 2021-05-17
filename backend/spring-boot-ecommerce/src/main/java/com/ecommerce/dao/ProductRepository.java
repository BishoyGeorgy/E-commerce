package com.ecommerce.dao;

import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author @Bishoy
 * @version 1.0
 * @date 08/04/2021
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long id);
    List<Product> findByNameContaining(String name);
}
