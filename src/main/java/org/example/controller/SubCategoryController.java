package org.example.controller;

import org.example.domain.SubCategory;

import java.util.Optional;

public interface SubCategoryController extends GeneralController<SubCategory, Integer>{
    Optional<SubCategory> findBySubCategoryName(String name);
}
