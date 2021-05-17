package com.ecommerce.dao;

import com.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author @Bishoy
 * @version 1.0
 * @date 08/04/2021
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
