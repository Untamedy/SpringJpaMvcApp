/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springApp.servicesImplements;

import com.springApp.entities.Photo;
import com.springApp.repositories.PhotoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springApp.service.PhotoService;

/**
 *
 * @author Lenovo
 */
@Service
public class PhotoServiceImplements implements PhotoService{

    public PhotoServiceImplements() {
    }
    
        
    
    @Autowired
    private PhotoRepository repository;

    @Override
    @Transactional
    public void add(Photo photo) {
        repository.save(photo);
    }

    @Override
    @Transactional
    public List<Photo> selectAllFoto() {
      return repository.findAll();
    }

    @Override
    @Transactional
    public Photo selectById(int id) {
        return repository.findById(id).get();
    }
        

    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    
    public void deletePhotos(int[] photos) {
       for(Integer id: photos){
          repository.deleteById(id);
       }
    }

    
}
