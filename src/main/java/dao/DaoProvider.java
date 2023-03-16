package dao;

import entity.Description;
import entity.Provider;

public interface DaoProvider extends DAO<Provider> {
    Provider findProviderById(Integer id);
}
