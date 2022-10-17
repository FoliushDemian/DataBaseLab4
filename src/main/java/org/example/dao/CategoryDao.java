package org.example.dao;
import org.example.domain.Category;

import java.util.Optional;

public interface CategoryDao extends GeneralDao<Category, Integer> {
    Optional<Category> findByCategoryName(String name);
}
