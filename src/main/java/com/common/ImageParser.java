/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.common;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Lenovo
 */
public class ImageParser {
    
    private String path;

    public ImageParser() {
    }

    public ImageParser(String path) {
        this.path = path;
    }
   
    

    public byte[] parsToByteArray(String path) {

        byte[] imageInByte = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {

            BufferedImage originalImage = ImageIO.read(new File(path));

            ImageIO.write(originalImage, "jpg", baos);
            baos.flush();
            imageInByte = baos.toByteArray();

            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                baos.close();
               
            } catch (IOException ex) {
                Logger.getLogger(ImageParser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return imageInByte;

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    

}
