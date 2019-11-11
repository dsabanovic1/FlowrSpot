package com.dzenansabanovicproject.dao;

import com.dzenansabanovicproject.model.DAOUser;
import com.dzenansabanovicproject.model.DaoFlower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerDao extends CrudRepository<DaoFlower, Integer> {
    //DaoFlower getDaoFlowerById(int id);
    List<DaoFlower> getDaoFlowersByDaoUser(DAOUser daoUser);
}
