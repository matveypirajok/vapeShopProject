package dao.daoImpl;

import dao.DaoImpl;
import dao.DaoShop;
import entity.Description;
import entity.Provider;
import entity.Shop;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoShopImpl extends DaoImpl<Shop> implements DaoShop {
    @Override
    public Shop findShopById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Shop> criteria = builder.createQuery(Shop.class);
        Root<Shop> shop = criteria.from(Shop.class);

        criteria.select(shop).where(builder.equal(shop.get("id"), id));

        Shop singleResult = em.createQuery(criteria).getSingleResult();
        return singleResult;

//        String sql = "from entity.Shop where entity.Shop.id = :id";
//        return (Shop)em.createQuery(sql).setParameter("id", id).getSingleResult();
    }
}
