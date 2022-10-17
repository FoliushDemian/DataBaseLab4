package org.example.controller.impl;

import org.example.controller.CategoryController;
import org.example.domain.Category;
import org.example.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public Optional<Category> findByCategoryName(String name) {
        return categoryService.findByCategoryName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public int create(Category category) {
        return categoryService.create(category);
    }

    @Override
    public int update(Integer id, Category category) {
        return categoryService.update(id, category);
    }

    @Override
    public int delete(Integer id) {
        return categoryService.delete(id);
    }
}
