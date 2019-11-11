package com.dzenansabanovicproject.controller;

import com.dzenansabanovicproject.model.FlowerDTO;
import com.dzenansabanovicproject.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public ResponseEntity<?> addFlower(@ModelAttribute FlowerDTO flowerDTO)  throws  Exception{

        return ResponseEntity.ok(flowerService.saveImage(flowerDTO));

    }

    @GetMapping(value="/myFlowers")
    public ResponseEntity<?> getMyFlowers(Principal principal){
            return ResponseEntity.ok(flowerService.getFlowers(principal.getName()));
    }
    @GetMapping(value="/flowers")
    public ResponseEntity<?> getFlowers(){
        return ResponseEntity.ok(flowerService.getAllFlowers());
    }
}
