/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Photo;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface PhotoDao {
    
    public void add(Photo photo);
    public List<Photo> selectAllFoto();
    public Photo selectById(int id);
    public void delete(Photo photo);
    
    
    
}
