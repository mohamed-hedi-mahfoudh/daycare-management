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
 * @author nejib
 */
public class LoginController {
    
    	public boolean verifLogin (Login l) throws SQLException
	{
		return l.verif();
	}
        
    
}
