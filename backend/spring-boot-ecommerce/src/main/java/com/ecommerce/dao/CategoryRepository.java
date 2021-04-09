package com.ecommerce.dao;

import com.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

/**
 * @author <a href="bishoy.georgy@incorta.com">Bishoy Georgy</a>
 * @version 1.0
 * @date 08/04/2021
 */
@RepositoryRestController
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
