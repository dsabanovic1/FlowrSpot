package com.dzenansabanovicproject.controller;

import com.dzenansabanovicproject.model.SightingDTO;
import com.dzenansabanovicproject.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SightingController {
    @Autowired
    private SightingService sightingService;
    @RequestMapping(value="/addsight", method = RequestMethod.POST)
    public ResponseEntity<?> addFlower(@RequestBody SightingDTO sighting)  throws  Exception{

        return ResponseEntity.ok(sightingService.saveSighting(sighting));

    }

    @GetMapping(value="/sightings/{flower_id}")
    public ResponseEntity<?> getSightingsForParticularFlower(@RequestParam int flower_id){
        return null;
    }
}
