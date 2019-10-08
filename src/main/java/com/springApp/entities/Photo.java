/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springApp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lenovo
 */

@Entity
public class Photo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String name;
    
    @Column(name = "photo")
    private String path;

    public Photo() {
    }

   
    public Photo(int id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public Photo(String name, String path) {
        this.name = name;
        this.path = path;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return path;
    }

    public void setFile(String file) {
        this.path = file;
    }
    
    
    
    
    
}
