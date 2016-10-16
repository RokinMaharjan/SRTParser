/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing.filehelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rokin
 */
public class FileHelper {

    public String readSrt(String fileName) throws IOException
    {
        BufferedReader srtReader = new BufferedReader(new FileReader("/home/rokin/Desktop/Subtitles/" + fileName));
        String srtLine = "";
        StringBuilder srtContent = new StringBuilder();

        while ((srtLine = srtReader.readLine()) != null) 
        {
            srtContent.append(srtLine).append("\n");
        }
        srtReader.close();
        
        return srtContent.toString();
    }
}
