package org.example.controller.impl;

import org.example.controller.ShopController;
import org.example.domain.Goods;
import org.example.domain.Shop;
import org.example.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopControllerImpl implements ShopController {

    private final ShopService shopService;

    public ShopControllerImpl(ShopService shopService) {
        this.shopService = shopService;
    }

    @Override
    public List<Shop> findAll() {
        return shopService.findAll();
    }

    @Override
    public Optional<Shop> findById(Integer id) {
        return shopService.findById(id);
    }

    @Override
    public int create(Shop shop) {
        return shopService.create(shop);
    }

    @Override
    public int update(Integer id, Shop shop) {
        return shopService.update(id, shop);
    }

    @Override
    public int delete(Integer id) {
        return shopService.delete(id);
    }

    @Override
    public Optional<Shop> findByShopName(String name) {
        return shopService.findByShopName(name);
    }

    @Override
    public List<Goods> findAllGoodsBy(Integer id) {
        return shopService.findAllGoodsBy(id);
    }
}
