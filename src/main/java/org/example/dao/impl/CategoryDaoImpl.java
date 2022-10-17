package org.example.dao.impl;

import org.example.dao.CategoryDao;
import org.example.domain.Category;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CategoryDaoImpl implements CategoryDao {

    private static final String FIND_ALL = "SELECT * FROM category";
    private static final String CREATE = "INSERT category(name) VALUES (?)";
    private static final String UPDATE = "UPDATE category SET name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM category WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM category WHERE id=?";
    private static final String FIND_BY_CATEGORY_NAME = "SELECT * FROM category WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    public CategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Category> findByCategoryName(String name) {
        Optional<Category> category;
        try {
            category = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_CATEGORY_NAME,
                    BeanPropertyRowMapper.newInstance(Category.class), name));
        } catch (EmptyResultDataAccessException e) {
            category = Optional.empty();
        }
        return category;
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Category.class));
    }

    @Override
    public Optional<Category> findById(Integer id) {
        Optional<Category> category;
        try {
            category = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Category.class), id));
        } catch (EmptyResultDataAccessException e) {
            category = Optional.empty();
        }
        return category;
    }

    @Override
    public int create(Category category) {
        return jdbcTemplate.update(CREATE, category.getName());
    }

    @Override
    public int update(Integer id, Category category) {
        return jdbcTemplate.update(UPDATE, category.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
