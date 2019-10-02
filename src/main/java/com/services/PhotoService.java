/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.dao.PhotoDao;
import com.entities.Photo;
import com.repositories.PhotoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */
@Service
public class PhotoService implements PhotoDao{

    public PhotoService() {
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
        

    @Override
    @Transactional
    public void delete(Photo photo) {
        repository.delete(photo);
    }
    
}
