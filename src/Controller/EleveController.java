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
public class EleveController {
    
    
    public EleveController() throws ClassNotFoundException, SQLException
	{
		
	}

	
	public boolean addEleve(Eleves e) throws SQLException
	{
		return e.add();
	}
		
	public boolean updateEleve(Eleves e) throws SQLException
	{
		return e.update();
	}
	public boolean deleteEleve(String id) throws SQLException
	{
		return new Eleves().delete(id);
	}
	public ArrayList<Eleves> listerEleve() throws SQLException
	{
		return new Eleves().listerele();
	}
        
        
        
        
        
        /*
        public ArrayList<Animateur> listerIDAnim() throws SQLException, ClassNotFoundException
	{
		return new Animateur().updateCombo();
	}
    
    
    */
    
    
    
}
