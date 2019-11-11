package com.dzenansabanovicproject.service;

import com.dzenansabanovicproject.dao.SightingDao;
import com.dzenansabanovicproject.model.DAOSighting;
import com.dzenansabanovicproject.model.SightingDTO;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class SightingService implements ISightingService {
    @Autowired
    private SightingDao sightingDao;
    @Autowired
    private FlowerService flowerService;
    @Autowired JwtUserDetailsService jwtUserDetailsService;

    @Override
    public DAOSighting saveSighting(SightingDTO sightingDTO) throws Exception {
       DAOSighting sighting = new DAOSighting();
       sighting.setLatitude(sightingDTO.getLatitude());
       sighting.setLongitude(sightingDTO.getLongitute());
       sighting.setDaoFlower(flowerService.getFlower(sightingDTO.getFlower()));
       sighting.setDaoUser(jwtUserDetailsService.getUserById(sightingDTO.getUser()));
       sighting.setQuote(helperQuote());
        return sightingDao.save(sighting);
    }

    public String helperQuote(){
        try{
        URI uri = new URI("https://api.quotable.io/random");
        JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
        JSONObject root = new JSONObject(tokener);
        return root.get("content").toString();

        }
        catch (Exception e){return e.getMessage();}

    }

    @Override
    public List<DAOSighting> getSightingForParticularFlower(int flowerId){
        //getFlowerById
 return null;
    }
}
