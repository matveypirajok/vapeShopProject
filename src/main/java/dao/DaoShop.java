package dao;

import entity.Description;
import entity.Shop;

public interface DaoShop extends DAO<Shop> {
    Shop findShopById(Integer id);
}
