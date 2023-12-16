/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author mohamed
 */
public class MyConnection {
    String filename= null;
    public static String path;
    private Connection c =null;
	private Statement stmt;
	
	public MyConnection() throws ClassNotFoundException, SQLException
	{
		// chargement du pilote spécifique au pilote de BD
		// (soit ODBC ou Driver personnalisé du SGBD):
    	Class.forName("com.mysql.cj.jdbc.Driver");	    	
    	
    	// Définition du contexte de la connection (URL de la connection):
    	String url="jdbc:mysql://localhost:3306/gestion_garderie?"
    			+ "serverTimezone=UTC";
    	// récuperer une réference vers la connexion 
    	// à la base de données (source de données) en question :
    	c=DriverManager.getConnection(url,"root","");
	}
	public Connection getC() {
		return c;
	}
	
	public int executeUpdate(String request) throws SQLException
	{
		stmt = c.createStatement();
		return stmt.executeUpdate(request);
		
	}
	
	public ResultSet executeQuery(String request) throws SQLException
	{
		stmt = c.createStatement();
		return stmt.executeQuery(request);
		
	}
        
        
        
        
        
        
        
        
        
        
        
        public void filen() {
        try {

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choisir une image png");
            chooser.setApproveButtonText("Ajouter une image");
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            this.path = (filename);
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null," Veuiler choisir une image ");;
        }
      
}
    public String getp(){
    
    return path;     
        
    }
        
        
        
        
        
        
        
        
    
}
