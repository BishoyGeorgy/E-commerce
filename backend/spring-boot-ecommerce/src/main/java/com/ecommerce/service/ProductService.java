package com.ecommerce.service;

import com.ecommerce.dao.ProductRepository;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO getProduct(long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return Mapper.toProductDTO(product.get());
        return null;
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Mapper::toProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> getProducts(long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream().map(Mapper::toProductDTO).collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsContaining(String keyword) {
        List<Product> products = productRepository.findByNameContaining(keyword);
        return products.stream().map(Mapper::toProductDTO).collect(Collectors.toList());
    }
}
