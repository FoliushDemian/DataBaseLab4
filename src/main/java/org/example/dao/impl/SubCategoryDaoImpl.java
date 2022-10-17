package org.example.dao.impl;

import org.example.dao.SubCategoryDao;
import org.example.domain.Category;
import org.example.domain.SubCategory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SubCategoryDaoImpl implements SubCategoryDao {

    private static final String FIND_ALL = "SELECT * FROM sub_category";
    private static final String CREATE = "INSERT sub_category(name, category_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE sub_category SET name=?, category_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM sub_category WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM sub_category WHERE id=?";
    private static final String FIND_BY_SUB_CATEGORY_NAME = "SELECT * FROM sub_category WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    public SubCategoryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SubCategory> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(SubCategory.class));
    }

    @Override
    public Optional<SubCategory> findById(Integer id) {
        Optional<SubCategory> subCategory;
        try {
            subCategory = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(SubCategory.class), id));
        } catch (EmptyResultDataAccessException e) {
            subCategory = Optional.empty();
        }
        return subCategory;
    }

    @Override
    public int create(SubCategory subCategory) {
        return jdbcTemplate.update(CREATE, subCategory.getName(), subCategory.getCategoryId());
    }

    @Override
    public int update(Integer id, SubCategory subCategory) {
        return jdbcTemplate.update(UPDATE, subCategory.getName(), subCategory.getCategoryId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<SubCategory> findBySubCategoryName(String name) {
        Optional<SubCategory> subCategory;
        try {
            subCategory = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SUB_CATEGORY_NAME,
                    BeanPropertyRowMapper.newInstance(SubCategory.class), name));
        } catch (EmptyResultDataAccessException e) {
            subCategory = Optional.empty();
        }
        return subCategory;
    }
}
