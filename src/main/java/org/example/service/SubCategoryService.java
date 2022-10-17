package org.example.service;

import org.example.domain.SubCategory;

import java.util.Optional;

public interface SubCategoryService extends GeneralService<SubCategory, Integer>{

    Optional<SubCategory> findBySubCategoryName(String name);
}
