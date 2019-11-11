package com.dzenansabanovicproject.service;

import com.dzenansabanovicproject.model.DAOSighting;
import com.dzenansabanovicproject.model.SightingDTO;

import java.util.List;

public interface ISightingService {

    public DAOSighting saveSighting(SightingDTO sightingDTO) throws Exception;
    public List<DAOSighting> getSightingForParticularFlower(int flowerId);
}
