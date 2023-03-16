package dao;

import utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoImpl<T> implements DAO<T>{
    protected static EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public T save(T object) {
        em.getTransaction().begin();
       // em.persist(object);
        object = em.merge(object);
        em.getTransaction().commit();
        return object;
    }

    @Override
    public void update(T object) {
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();

    }

    @Override
    public T findById(T object) {
        return (T) em.find(object.getClass(), object);
    }

    @Override
    public void delete(T object) {
        em.getTransaction().begin();
        em.remove(em.contains(object) ? object : em.merge(object));
        em.getTransaction().commit();
    }

    @Override
    public List<T> findAll(T object) {
        String sql = "from " + object.getClass().getSimpleName();
        return em.createQuery(sql).getResultList();
    }
}
