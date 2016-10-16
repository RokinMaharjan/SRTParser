/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing.elementextractor;

import com.rokin.srtindexing.dao.ElementDAO;
import com.rokin.srtindexing.dao.impl.ElementDAOImpl;
import com.rokin.srtindexing.entity.Element;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rokin
 */
public class ElementExtractor {

    public void extractElements(String srtContent, String fileName) throws IOException, SQLException, ClassNotFoundException 
    {
        String nl = "\\n";
        String sp = "[ \\t]*";
        String regex = "(\\d+)" + sp + nl
                + "(\\d{1,2}):(\\d\\d):(\\d\\d),(\\d\\d\\d)" + sp
                + "-->" + sp + "(\\d\\d):(\\d\\d):(\\d\\d),(\\d\\d\\d)" + sp
                + "(X1:\\d.*?)??" + nl + "([^\\|]*?)" + nl + nl;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(srtContent.toString());
        while (matcher.find()) 
        {
            String startTime = matcher.group(2) + ":" + matcher.group(3) + ":" + matcher.group(4) + ":" + matcher.group(5);
            String endTime = matcher.group(6) + ":" + matcher.group(7) + ":" + matcher.group(8) + ":" + matcher.group(9);
            String text = matcher.group(11);
            
//            System.out.println(startTime);
//            System.out.println(endTime);
//            System.out.println(text);
            
            
            String[] tokens = text.replace("\n", " ").replace("\"", "").replace(",", "").replace(".", "").split(" ");
            
            
            ElementDAO elementDAOImpl = new ElementDAOImpl();
           
            for(int i=0; i<tokens.length; i++)
            {
                System.out.println(tokens[i] + "=========" + startTime + "======" + endTime);                
                elementDAOImpl.insertElement(new Element(1, tokens[i], startTime, endTime, fileName, "No comments"));
            }
        }
    }
}
