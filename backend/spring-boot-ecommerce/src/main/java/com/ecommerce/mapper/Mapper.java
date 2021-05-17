package com.ecommerce.mapper;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
public class Mapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getName(), category.getId());
    }

    public static ProductDTO toProductDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getUnitPrice().doubleValue(), product.getImageUrl());
    }
}
