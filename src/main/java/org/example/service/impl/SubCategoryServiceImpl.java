package org.example.service.impl;

import org.example.dao.SubCategoryDao;
import org.example.domain.SubCategory;
import org.example.service.SubCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryDao subCategoryDao;

    public SubCategoryServiceImpl(SubCategoryDao subCategoryDao) {
        this.subCategoryDao = subCategoryDao;
    }

    @Override
    public List<SubCategory> findAll() {
        return subCategoryDao.findAll();
    }

    @Override
    public Optional<SubCategory> findById(Integer id) {
        return subCategoryDao.findById(id);
    }

    @Override
    public int create(SubCategory subCategory) {
        return subCategoryDao.create(subCategory);
    }

    @Override
    public int update(Integer id, SubCategory subCategory) {
        return subCategoryDao.update(id, subCategory);
    }

    @Override
    public int delete(Integer id) {
        return subCategoryDao.delete(id);
    }

    @Override
    public Optional<SubCategory> findBySubCategoryName(String name) {
        return subCategoryDao.findBySubCategoryName(name);
    }
}
