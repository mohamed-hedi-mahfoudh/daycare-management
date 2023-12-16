/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import Model.Animateur;
import Model.Classe;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mohamed
 */
public class ClasseController {
    
    
    
    public ArrayList<Classe> listerClasse() throws SQLException, ClassNotFoundException
	{
		return new Classe().lister();
                                             
	}
    
    
    
    public boolean addClasse(Classe cl) throws SQLException
	{
		return cl.add();
	}
		
	
	public boolean deleteClasse(String s) throws SQLException
	{
		return new Classe().delete(s);
	}
    
    
    
    
    public ArrayList<Animateur> listeranim(String s) throws SQLException, ClassNotFoundException
	{
		return new Classe().listeranim(s);
                                             
	}
    
    
     public ArrayList<Eleves> listereleve(String s) throws SQLException, ClassNotFoundException
	{
		return new Classe().listereleve(s);
                                             
	}
    
    
    public ArrayList<Cours> listercours(String s) throws SQLException, ClassNotFoundException
	{
		return new Classe().listercours(s);
                                             
	}
    
    
    
}
