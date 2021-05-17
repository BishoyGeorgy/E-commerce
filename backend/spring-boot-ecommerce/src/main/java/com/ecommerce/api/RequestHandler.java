package com.ecommerce.api;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.service.CategoryService;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
@RestController
@CrossOrigin
@RequestMapping("api")
public class RequestHandler {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category/{id}")
    public CategoryDTO getCategory(@PathVariable long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/product/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{categoryId}")
    public List<ProductDTO> getProductsByCategoryId(@PathVariable long categoryId) {
        return productService.getProducts(categoryId);
    }

    @GetMapping("/products/search")
    public List<ProductDTO> getProductsContaining(@PathParam(value = "keyword") String keyword) {
        return productService.getProductsContaining(keyword);
    }
}
