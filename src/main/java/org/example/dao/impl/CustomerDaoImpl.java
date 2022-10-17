package org.example.dao.impl;

import org.example.dao.CustomerDao;
import org.example.domain.Category;
import org.example.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class CustomerDaoImpl implements CustomerDao {

    private static final String FIND_ALL = "SELECT * FROM customer";
    private static final String CREATE = "INSERT customer(name, email, phone_number) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE customer SET name=?, email=?, phone_number=? WHERE id=?";
    private static final String DELETE = "DELETE FROM customer WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM customer WHERE id=?";
    private static final String FIND_BY_CUSTOMER_NAME = "SELECT * FROM customer WHERE name=?";
    private static final String FIND_BY_CUSTOMER_EMAIL = "SELECT * FROM customer WHERE email=?";

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Customer> findByCustomerName(String name) {
        Optional<Customer> customer;
        try {
            customer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_CUSTOMER_NAME,
                    BeanPropertyRowMapper.newInstance(Customer.class), name));
        } catch (EmptyResultDataAccessException e) {
            customer = Optional.empty();
        }
        return customer;
    }

    @Override
    public Optional<Customer> findByCustomerEmail(String email) {
        Optional<Customer> customer;
        try {
            customer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_CUSTOMER_EMAIL,
                    BeanPropertyRowMapper.newInstance(Customer.class), email));
        } catch (EmptyResultDataAccessException e) {
            customer = Optional.empty();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Customer.class));
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        Optional<Customer> customer;
        try {
            customer = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Customer.class), id));
        } catch (EmptyResultDataAccessException e) {
            customer = Optional.empty();
        }
        return customer;
    }

    @Override
    public int create(Customer customer) {
        return jdbcTemplate.update(CREATE, customer.getName(), customer.getEmail(), customer.getPhoneNumber());
    }

    @Override
    public int update(Integer id, Customer customer) {
        return jdbcTemplate.update(UPDATE, customer.getName(), customer.getEmail(), customer.getPhoneNumber(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
