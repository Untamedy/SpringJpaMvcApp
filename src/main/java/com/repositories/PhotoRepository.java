/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repositories;

import com.dao.PhotoDao;
import com.entities.Photo;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository("custimerRepository")
public interface PhotoRepository extends JpaRepository<Photo,Integer>{
    
   
    
}
