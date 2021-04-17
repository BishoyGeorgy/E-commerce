package com.ecommerce.api;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired CategoryMapper categoryMapper;

    @GetMapping("/category/{id}")
    public CategoryDTO getCategory(@PathVariable long id) {
        return categoryMapper.getCategory(id);
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.getCategories();
    }
}
