package dao;

import entity.Description;

public interface DaoDescription extends DAO<Description> {
    Description findDescriptionById(Integer id);
}
