package org.example.dao;

import org.example.domain.Category;
import org.example.domain.Customer;
import org.example.domain.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryDao extends GeneralDao<SubCategory, Integer>{
    Optional<SubCategory> findBySubCategoryName(String name);
}
