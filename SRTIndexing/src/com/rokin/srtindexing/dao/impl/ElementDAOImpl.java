/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing.dao.impl;

import com.rokin.srtindexing.dao.ElementDAO;
import com.rokin.srtindexing.dbutil.DBConnection;
import com.rokin.srtindexing.entity.Element;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rokin
 */
public class ElementDAOImpl implements ElementDAO{
    
    private DBConnection db = new DBConnection();
    
    @Override
    public List<Element> getAll() throws SQLException, ClassNotFoundException{
        db.openConnection();
        List<Element> elementList = new ArrayList<>();
        String sql = "SELECT * FROM word_index";
        PreparedStatement stmt = db.initStatement(sql);
        ResultSet rs = db.executeQuery();
        while(rs.next())
        {
            Element element = new Element();
            element.setId(rs.getInt("Id"));
            element.setWord(rs.getString("Word"));
            element.setStartTime(rs.getString("Start_Time"));
            element.setEndTime(rs.getString("End_Time"));
            element.setVideo(rs.getString("Video"));
            element.setComments(rs.getString("Comments"));
            
            
            elementList.add(element);
        }
        db.closeConnection(); 
        return elementList;
    }


    @Override
    public int insertElement(Element element) throws ClassNotFoundException, SQLException {
        db.openConnection();
        String sql = "INSERT INTO word_index(Word, Start_Time, End_Time, Video, Comments) VALUES(?,?,?,?,?)";
        
        PreparedStatement stmt = db.initStatement(sql);
        
        stmt.setString(1, element.getWord());
        stmt.setString(2, element.getStartTime());
        stmt.setString(3, element.getEndTime());
        stmt.setString(4, element.getVideo());
        stmt.setString(5, element.getComments());
        
        int result = stmt.executeUpdate();
        
        db.closeConnection();
        return result;
    }
    
}
