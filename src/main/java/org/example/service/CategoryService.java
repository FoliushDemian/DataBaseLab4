package org.example.service;

import org.example.domain.Category;

import java.util.Optional;

public interface CategoryService extends GeneralService<Category, Integer>{
    Optional<Category> findByCategoryName(String name);
}
