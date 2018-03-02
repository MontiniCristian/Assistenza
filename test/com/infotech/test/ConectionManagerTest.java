/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.test;

import com.infotech.model.ConnectionManager;
import com.infotech.model.InfotechDAO;
import com.infotech.model.Tecnico;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreapollini
 */
public class ConectionManagerTest {
    
    public ConectionManagerTest() {
        
    }
    
    @Test
    public void testConnectionOK() {
        Connection c = ConnectionManager.getConnection();
        assertNotNull(c);
    }
    
    @Test
    public void testTecnico() {
        Tecnico t = new Tecnico();
        t.setNome("Pinco Pallo");
        t.setTelefono("030232783728");
        boolean ret = InfotechDAO.save(t);
        //inserimento a buon fine
        assertTrue(ret);
        
        boolean found = false;
        for(Tecnico tecnico:  InfotechDAO.getAllTecnico()) {
            if (t.getNome().equals(tecnico.getNome()) &&
                    t.getTelefono().equals(tecnico.getTelefono()))
                found = true;
        }
        
        assertTrue(found);
        
        
    }
    
}
