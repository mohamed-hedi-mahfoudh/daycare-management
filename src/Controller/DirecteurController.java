/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.SQLException;

/**
 *
 * @author mohamed
 */
public class DirecteurController {
    
    
    public boolean verif_conn(String log,String pass) throws SQLException
	{
		return new Directeur().verif(log, pass);
	}
    
    
}
