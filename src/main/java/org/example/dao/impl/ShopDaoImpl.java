package org.example.dao.impl;

import org.example.dao.ShopDao;
import org.example.domain.Category;
import org.example.domain.Goods;
import org.example.domain.Shop;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ShopDaoImpl implements ShopDao {

    private static final String FIND_ALL = "SELECT * FROM shop";
    private static final String CREATE = "INSERT shop(name, min_order_amount) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE shop SET name=?, min_order_amount=? WHERE id=?";
    private static final String DELETE = "DELETE FROM shop WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM shop WHERE id=?";
    private static final String FIND_BY_SHOP_NAME = "SELECT * FROM shop WHERE name=?";
    private static final String FIND_ALL_GOODS = "SELECT * FROM goods WHERE EXISTS(SELECT * FROM shop_goods WHERE goods_id=id and shop_id=?)";

    private final JdbcTemplate jdbcTemplate;

    public ShopDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Shop> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Shop.class));
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        Optional<Shop> shop;
        try {
            shop = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Shop.class), id));
        } catch (EmptyResultDataAccessException e) {
            shop = Optional.empty();
        }
        return shop;
    }

    @Override
    public int create(Shop shop) {
        return jdbcTemplate.update(CREATE, shop.getName(), shop.getMinOrderAmount());
    }

    @Override
    public int update(Integer id, Shop shop) {
        return jdbcTemplate.update(UPDATE, shop.getName(), shop.getMinOrderAmount(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }

    @Override
    public Optional<Shop> findByShopName(String name) {
        Optional<Shop> shop;
        try {
            shop = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SHOP_NAME,
                    BeanPropertyRowMapper.newInstance(Shop.class), name));
        } catch (EmptyResultDataAccessException e) {
            shop = Optional.empty();
        }
        return shop;
    }

    @Override
    public List<Goods> findAllGoodsBy(Integer id) {
        return jdbcTemplate.query(FIND_ALL_GOODS, BeanPropertyRowMapper.newInstance(Goods.class), id);
    }
}
