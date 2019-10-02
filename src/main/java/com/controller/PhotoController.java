/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.entities.Photo;
import com.services.PhotoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {
    
    @Autowired
    private PhotoService photoService;
    
    @GetMapping("/all")
    public String photos(Model model){
        List<Photo> photos = photoService.selectAllFoto();
        model.addAttribute("photo", photos);        
        return "list photos";        
    }
    
    
    
    
    
}
