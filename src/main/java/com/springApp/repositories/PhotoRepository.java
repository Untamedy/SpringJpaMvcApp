package com.springApp.repositories;


import com.springApp.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */
@Repository("custimerRepository")
public interface PhotoRepository extends JpaRepository<Photo,Integer>{
    
    public void deleteById(int id);

    @Query("select max(p.id) from Photo p ")
    public int selectMaxId();
    
    public boolean exsists(String name);
    
   
    
}
