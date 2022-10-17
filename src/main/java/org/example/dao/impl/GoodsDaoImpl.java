package org.example.dao.impl;

import org.example.dao.GoodsDao;
import org.example.domain.Category;
import org.example.domain.Customer;
import org.example.domain.Goods;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class GoodsDaoImpl implements GoodsDao {

    private static final String FIND_ALL = "SELECT * FROM goods";
    private static final String CREATE = "INSERT goods(name, price, expiration_date, customer_id) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE goods SET name=?, price=?, expiration_date=?, customer_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM goods WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM goods WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public GoodsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Goods> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Goods.class));
    }

    @Override
    public Optional<Goods> findById(Integer id) {
        Optional<Goods> goods;
        try {
            goods = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Goods.class), id));
        } catch (EmptyResultDataAccessException e) {
            goods = Optional.empty();
        }
        return goods;
    }

    @Override
    public int create(Goods goods) {
        return jdbcTemplate.update(CREATE, goods.getName(), goods.getPrice(), goods.getExpirationDate(), goods.getCustomerId());
    }

    @Override
    public int update(Integer id, Goods goods) {
        return jdbcTemplate.update(UPDATE,  goods.getName(), goods.getPrice(), goods.getExpirationDate(), goods.getCustomerId(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
