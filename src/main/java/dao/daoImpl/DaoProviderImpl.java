package dao.daoImpl;

import dao.DaoImpl;
import dao.DaoProvider;
import entity.Description;
import entity.Provider;

public class DaoProviderImpl extends DaoImpl<Provider> implements DaoProvider {
    @Override
    public Provider findProviderById(Integer id) {
        String sql = "from entity.Provider where entity.Provider.id = :id";
        return (Provider) em.createQuery(sql).setParameter("id", id).getSingleResult();
    }
}
