package org.example.service.impl;

import org.example.dao.GoodsDao;
import org.example.domain.Goods;
import org.example.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsDao goodsDao;

    public GoodsServiceImpl(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    @Override
    public List<Goods> findAll() {
        return goodsDao.findAll();
    }

    @Override
    public Optional<Goods> findById(Integer id) {
        return goodsDao.findById(id);
    }

    @Override
    public int create(Goods goods) {
        return goodsDao.create(goods);
    }

    @Override
    public int update(Integer id, Goods goods) {
        return goodsDao.update(id, goods);
    }

    @Override
    public int delete(Integer id) {
        return goodsDao.delete(id);
    }
}
