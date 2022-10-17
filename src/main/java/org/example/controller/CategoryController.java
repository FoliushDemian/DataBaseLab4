package org.example.controller;

import org.example.domain.Category;

import java.util.Optional;

public interface CategoryController extends GeneralController<Category, Integer>{
    Optional<Category> findByCategoryName(String name);
}
