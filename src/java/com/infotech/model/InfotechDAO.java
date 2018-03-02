/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andreapollini
 */
public class InfotechDAO {
    
    public static boolean save(Tecnico t) {
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT"
                    + " INTO tecnico (nome, telefono) VALUES(?,?)");
            st.setString(1, t.getNome());
            st.setString(2, t.getTelefono());
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InfotechDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public static List<Tecnico> getAllTecnico() {
        List<Tecnico> tecnici = new ArrayList<>();
        try {
            try (Connection conn = ConnectionManager.getConnection()) {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM tecnico");
                while(rs.next()) {
                    Tecnico t = new Tecnico();
                    t.setId(rs.getInt("id"));
                    t.setNome(rs.getString("nome"));
                    t.setTelefono(rs.getString("telefono"));
                    tecnici.add(t);
                }
                rs.close();
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InfotechDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return tecnici;
    }
    
}
