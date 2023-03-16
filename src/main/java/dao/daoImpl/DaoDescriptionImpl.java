package dao.daoImpl;

import dao.DaoDescription;
import dao.DaoImpl;
import entity.Description;
import utils.HibernateUtil;

import javax.persistence.EntityManager;

public class DaoDescriptionImpl extends DaoImpl<Description> implements DaoDescription {

    @Override
    public Description findDescriptionById(Integer id) {
        String sql = "from entity.Description where id = :id";
        return (Description)em.createQuery(sql).setParameter("id", id).getSingleResult();
    }
}
