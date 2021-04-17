package com.ecommerce.mapper;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Bishoy Georgy
 * @version 1.0
 * @date 17/04/2021
 */
@Component
public class CategoryMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO getCategory(long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) return toCategoryDTO(category.get());
        return null;
    }

    private static CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getName(), category.getId());
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
    }
}
