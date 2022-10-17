package org.example.controller.impl;

import org.example.controller.SubCategoryController;
import org.example.domain.SubCategory;
import org.example.service.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryControllerImpl implements SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryControllerImpl(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryService.findAll();
    }

    @Override
    public Optional<SubCategory> findById(Integer id) {
        return subCategoryService.findById(id);
    }

    @Override
    public int create(SubCategory subCategory) {
        return subCategoryService.create(subCategory);
    }

    @Override
    public int update(Integer id, SubCategory subCategory) {
        return subCategoryService.update(id, subCategory);
    }

    @Override
    public int delete(Integer id) {
        return subCategoryService.delete(id);
    }

    @Override
    public Optional<SubCategory> findBySubCategoryName(String name) {
        return subCategoryService.findBySubCategoryName(name);
    }
}
