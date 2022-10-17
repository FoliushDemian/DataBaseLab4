package org.example.service;

import org.example.domain.Goods;
import org.example.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService extends GeneralService<Shop, Integer>{

    Optional<Shop> findByShopName(String name);

    List<Goods> findAllGoodsBy(Integer id);
}
