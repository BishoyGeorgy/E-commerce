package com.ecommerce.dao;

import com.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author @Bishoy
 * @version 1.0
 * @date 08/04/2021
 */
@CrossOrigin
public interface ProductRepository extends JpaRepository<Product, Long> {
}
