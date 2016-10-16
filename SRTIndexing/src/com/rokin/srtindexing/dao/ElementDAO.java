/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.srtindexing.dao;

import com.rokin.srtindexing.entity.Element;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rokin
 */
public interface ElementDAO {
    List<Element> getAll() throws SQLException, ClassNotFoundException;
    int insertElement(Element element) throws SQLException, ClassNotFoundException;
}
