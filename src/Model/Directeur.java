/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Acceuil;
import java.sql.SQLException;

/**
 *
 * @author mohamed
 */
public class Directeur {
    
    
    String login;
    String password;
    String nom;
    String prenom;
    String type;

    public Directeur(String login, String password, String nom, String prenom, String type) {
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }

    public Directeur() {
    }

    
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
     public boolean verif(String log , String pass) throws SQLException {
        String MyRequest = "select login,password from directeur "
				+ " where login='"+ log +"'and password='"+pass+"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }
     
     
    
    
    
    
}
