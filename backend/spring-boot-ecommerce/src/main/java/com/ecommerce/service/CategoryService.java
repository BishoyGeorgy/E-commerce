package com.ecommerce.service;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
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
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO getCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) return Mapper.toCategoryDTO(category.get());
        return null;
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(Mapper::toCategoryDTO).collect(Collectors.toList());
    }
}
