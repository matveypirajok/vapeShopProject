package dao.daoImpl;

import dao.DaoDescription;
import dao.DaoImpl;
import entity.Description;
import entity.Shop;
import javassist.runtime.Desc;
import sun.security.krb5.internal.crypto.Des;
import utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoDescriptionImpl extends DaoImpl<Description> implements DaoDescription {

    @Override
    public Description findDescriptionById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Description> criteria = builder.createQuery(Description.class);
        Root<Description> description = criteria.from(Description.class);

        criteria.select(description).where(builder.equal(description.get("id"), id));

        Description singleResult = em.createQuery(criteria).getSingleResult();
        return singleResult;
    }
}
