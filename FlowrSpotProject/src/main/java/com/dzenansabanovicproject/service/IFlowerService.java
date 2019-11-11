package com.dzenansabanovicproject.service;

import com.dzenansabanovicproject.model.DaoFlower;
import com.dzenansabanovicproject.model.FlowerDTO;

import java.util.List;

public interface IFlowerService {

    public DaoFlower saveImage(FlowerDTO flowerDTO) throws Exception;
    public DaoFlower getFlower(int id);
    public List<DaoFlower> getFlowers(String name);
    public List<DaoFlower> getAllFlowers();
}
