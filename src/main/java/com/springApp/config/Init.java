/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springApp.config;

import com.springApp.entities.Photo;
import com.springApp.repositories.PhotoRepository;
import java.io.File;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lenovo
 */
@Component
public class Init {

    @Autowired
    private PhotoRepository repository;

    @PostConstruct
    private void postConstructor() {
       File file = new File("C:\\Users\\Lenovo\\Documents\\SpringApp\\src\\main\\resources\\photo");
        File[] files = file.listFiles();

        if (0 != files.length) {
            for (File f : files) {
                Photo photo = new Photo(f.getName(), f.getAbsolutePath());               
                repository.save(photo);
            }
        }
    }
}
