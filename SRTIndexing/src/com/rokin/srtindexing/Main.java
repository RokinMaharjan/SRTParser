/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing;

import com.rokin.srtindexing.elementextractor.ElementExtractor;
import com.rokin.srtindexing.filehelper.FileHelper;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rokin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {      
            FileHelper fileHelper = new FileHelper();
            ElementExtractor elementExtractor = new ElementExtractor();     
            
            BufferedReader fileReader = new BufferedReader(new FileReader("/home/rokin/Desktop/Subtitles/Files"));
            String fileName = "";
            while((fileName = fileReader.readLine()) != null)
            {
                String srtContent = fileHelper.readSrt(fileName);
                elementExtractor.extractElements(srtContent, fileName);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
