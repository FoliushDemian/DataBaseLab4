package org.example.controller.impl;

import org.example.controller.GoodsController;

import org.example.domain.Goods;
import org.example.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodsControllerImpl implements GoodsController {

    private final GoodsService goodsService;

    public GoodsControllerImpl(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    public List<Goods> findAll() {
        return goodsService.findAll();
    }

    @Override
    public Optional<Goods> findById(Integer id) {
        return goodsService.findById(id);
    }

    @Override
    public int create(Goods goods) {
        return goodsService.create(goods);
    }

    @Override
    public int update(Integer id, Goods goods) {
        return goodsService.update(id, goods);
    }

    @Override
    public int delete(Integer id) {
        return goodsService.delete(id);
    }
}
