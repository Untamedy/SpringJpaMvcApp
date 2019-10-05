/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springApp.controller;

import com.springApp.entities.Photo;
import com.springApp.servicesImplements.PhotoServiceImplements;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
    
    @Autowired
    private PhotoServiceImplements photoService;
    
    @GetMapping("/all")
    public String photos(Model model){
        List<Photo> photos = photoService.selectAllFoto();
        model.addAttribute("photo", photos);        
        return "list photos";        
    }
    
    @PostMapping("/delet{photo_id}")
    public String deletePhoto(@RequestParam("id")int id){       
        photoService.delete(id); 
        return "redirect:/all";
        
    }
    
    
     @PostMapping( "/delete/this{listPhoto}")
    public ResponseEntity<Void> delete(@RequestParam(value = "photos[]", required = false) int[] photos) {
        if (photos != null && photos.length > 0)
            photoService.deletePhotos(photos);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    
    
}
