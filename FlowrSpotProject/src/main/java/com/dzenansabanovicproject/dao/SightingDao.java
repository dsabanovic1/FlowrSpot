package com.dzenansabanovicproject.dao;

import com.dzenansabanovicproject.model.DAOSighting;
import com.dzenansabanovicproject.model.DaoFlower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SightingDao extends CrudRepository<DAOSighting, Integer> {

    List<DAOSighting> getAllByDaoFlower(DaoFlower daoFlower);
}
