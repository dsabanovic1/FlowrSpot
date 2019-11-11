package com.dzenansabanovicproject.service;

import com.dzenansabanovicproject.dao.FlowerDao;
import com.dzenansabanovicproject.dao.UserDao;
import com.dzenansabanovicproject.model.DaoFlower;
import com.dzenansabanovicproject.model.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlowerService implements IFlowerService {

    @Autowired
    FlowerDao flowerDao;
    @Autowired
    JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    UserDao userDao;

    @Override
    public DaoFlower saveImage(FlowerDTO flowerDTO) throws Exception {
        String folder = "/photos/";
        byte[] bytes = flowerDTO.getImage().getBytes();
        Path path = Paths.get(folder + flowerDTO.getName());
        Files.write(path,bytes);
        DaoFlower newFlower = new DaoFlower();
        newFlower.setName(flowerDTO.getName());
        newFlower.setDescription(flowerDTO.getDescription());
        newFlower.setUrl(path.toString());
        return flowerDao.save(newFlower);
    }

    @Override
    public DaoFlower getFlower(int flowerId) {
        return flowerDao.findById(flowerId).get();
    }

    @Override
    public List<DaoFlower> getFlowers(String name){
        return flowerDao.getDaoFlowersByDaoUser(userDao.findByUsername(name));
    }

    @Override
    public List<DaoFlower> getAllFlowers(){
        List<DaoFlower> allFlowers = new ArrayList<>();
        flowerDao.findAll().forEach(e->allFlowers.add(e));
        return allFlowers;
    }


}
