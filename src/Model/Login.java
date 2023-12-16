/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Acceuil;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nejib
 */
public class Login {
    public static MyConnection myConnection = null;
    
    private String login ;
    private String password;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Login() {
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
    
    public boolean verif() throws SQLException{
        
       String MyRequest = "select login, password from login_table  where login ='"+ this.getLogin() +"'"+ "and password='"+ this.getPassword() +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
                        
    
    }
    
    
    
    
}
