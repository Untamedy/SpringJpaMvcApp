/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springApp.controller;

import com.springApp.entities.Photo;
import com.springApp.service.PhotoService;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Lenovo
 */
@Controller
@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/all")
    public String photos(Model model) {
        List<Photo> photos = photoService.selectAllFoto();
        model.addAttribute("photos", photos);
        return "all";
    }

    @PostMapping("/delete{photos}")
    public String delete(@RequestParam(value = "photos", required = false) String[] photos) {
        if (photos != null && photos.length > 0) {
            for (String p : photos) {
                photoService.delete(Integer.valueOf(p));
            }
        } else {
            return "error";
        }
        return "result";
    }

    @GetMapping("/getPhoto{id}")
    public String photos(@RequestParam(value = "id") String id, Model model) {
        Photo photo = photoService.selectById(Integer.valueOf(id));
        model.addAttribute("path", photo.getFile());
        return "viewPhoto";
    }

    @GetMapping("/add")
    public String addPhoto() {
        return "add";
    }

    @PostMapping(value = "/add_photo")
    public String onAddPhoto(Model model, @RequestParam MultipartFile photo) {
        if (photo.isEmpty()) {
            return "error";
        }
        try {
            int id = new Random().nextInt();
            File file = new File("C:\\Users\\YBolshakova\\Documents\\gs-maven\\SpringApp\\src\\main\\resources\\photo\\photo" + id + ".jpg");
            FileOutputStream writer = new FileOutputStream(file);
            writer.write(photo.getBytes());
        } catch (IOException ex) {
            return "error";
        }
        return "result";

    }

    @GetMapping("/archive")
    public String arcivePhoto(Model model) {
        List<Photo> photos = photoService.selectAllFoto();
        model.addAttribute("photos", photos);
        return "archive";
    }

    @PostMapping(value = "/addToArcive")
    public ResponseEntity<byte[]> addToArchive(@RequestParam(value = "photos", required = false) String[] photos) throws IOException {
        OutputStream zipOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zippedFile = new ZipOutputStream(zipOutputStream);
         HttpHeaders headers = new HttpHeaders();
        for (String s : photos) {
            Photo photo = photoService.selectById(Integer.valueOf(s));
            String path = photo.getFile();
            if (path != null) {
                try {
                    InputStream reader = new FileInputStream(new File(path));
                    byte[] tmp = new byte[1024];
                    int read = 0;
                    while (read != -1) {
                       read = reader.read(tmp);
                    }
                    zippedFile.putNextEntry(new ZipEntry(photo.getName()));
                    zippedFile.write(tmp);                    
                }catch(FileNotFoundException ex){
                        
            }
        }
                    zippedFile.closeEntry();
                    zippedFile.close();
                    zipOutputStream.close();                    
                   
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    headers.set("Content-disposition", "attachment; filename=PhotoArcive.zip");
                   
               
            }
         return new ResponseEntity<>(((ByteArrayOutputStream) zipOutputStream).toByteArray(), headers, HttpStatus.OK);
        }

       

    

}
