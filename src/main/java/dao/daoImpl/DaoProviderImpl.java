package dao.daoImpl;

import dao.DaoImpl;
import dao.DaoProvider;
import entity.Description;
import entity.Provider;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DaoProviderImpl extends DaoImpl<Provider> implements DaoProvider {
    @Override
    public Provider findProviderById(Integer id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Provider> criteria = builder.createQuery(Provider.class);
        Root<Provider> provider = criteria.from(Provider.class);

        criteria.select(provider).where(builder.equal(provider.get("id"), id));

        Provider singleResult = em.createQuery(criteria).getSingleResult();
        return singleResult;
//
//        String sql = "from entity.Provider where entity.Provider.id = :id";
//        return (Provider) em.createQuery(sql).setParameter("id", id).getSingleResult();
    }
}
