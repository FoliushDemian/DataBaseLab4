package org.example.dao;

import org.example.domain.Customer;
import org.example.domain.Goods;
import org.example.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDao extends GeneralDao<Shop, Integer>{
    Optional<Shop> findByShopName(String name);

    List<Goods> findAllGoodsBy(Integer id);
}
