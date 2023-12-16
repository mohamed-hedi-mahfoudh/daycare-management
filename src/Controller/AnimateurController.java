/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mohamed
 */
public class AnimateurController {
    
    
    
    public AnimateurController() throws ClassNotFoundException, SQLException
	{
		
	}

	
	public boolean addAnimateur(Animateur a) throws SQLException
	{
		return a.add();
	}
		
	public boolean updateAnimateur(Animateur a) throws SQLException
	{
		return a.update();
	}
	public boolean deleteAnimateur(String _cin) throws SQLException
	{
		return new Animateur().delete(_cin);
	}
	public ArrayList<Animateur> listerAnimateur() throws SQLException
	{
		return new Animateur().lister();
	}
        public ArrayList<Animateur> listerIDAnim() throws SQLException, ClassNotFoundException
	{
		return new Animateur().updateCombo();
	}
        
    
    
}
