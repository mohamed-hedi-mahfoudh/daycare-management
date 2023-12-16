/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Animateur;
import Model.Classe;
import Model.Cours;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mohamed
 */
public class CoursController {
    
    
    public CoursController() throws ClassNotFoundException, SQLException
	{
		
	}

	
	public boolean addCours(Cours c) throws SQLException
	{
		return c.add();
	}
		
	public boolean updateCours(Cours c) throws SQLException
	{
		return c.update();
	}
	public boolean deleteCours(String code) throws SQLException
	{
		return new Cours().delete(code);
	}
	public ArrayList<Cours> listerCours() throws SQLException
	{
		return new Cours().lister();
	}
    
        public boolean eff_anim_cours_classe(String cin,String co,String cl) throws SQLException
	{
		return new Cours().effecetuer_anim_classe(cin, co,cl);
	}
        
        
        
        public ArrayList<Animateur> listeranim(String s) throws SQLException, ClassNotFoundException
	{
		return new Cours().listeranim(s);
                                             
	}
        
        
        
       public ArrayList<Classe> listerClasse(String s) throws SQLException, ClassNotFoundException
	{
		return new Cours().listerclasse(s);
                                             
	}
        
}
