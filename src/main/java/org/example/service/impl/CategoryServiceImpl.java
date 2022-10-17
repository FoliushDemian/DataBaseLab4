package org.example.service.impl;

import org.example.dao.CategoryDao;
import org.example.domain.Category;
import org.example.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Optional<Category> findByCategoryName(String name) {
        return categoryDao.findByCategoryName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public int create(Category category) {
        return categoryDao.create(category);
    }

    @Override
    public int update(Integer id, Category category) {
        return categoryDao.update(id, category);
    }

    @Override
    public int delete(Integer id) {
        return categoryDao.delete(id);
    }
}
