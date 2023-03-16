package dao.daoImpl;

import dao.DaoImpl;
import dao.DaoShop;
import entity.Description;
import entity.Shop;

public class DaoShopImpl extends DaoImpl<Shop> implements DaoShop {
    @Override
    public Shop findShopById(Integer id) {
        String sql = "from entity.Shop where entity.Shop.id = :id";
        return (Shop)em.createQuery(sql).setParameter("id", id).getSingleResult();
    }
}
