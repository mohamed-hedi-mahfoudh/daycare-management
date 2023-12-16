package Model;

import View.Acceuil;
import static View.Acceuil.myConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Animateur extends Personne{
    
    private String num_tel ;
    public static MyConnection myConnection = null;
    private Object comboclasse;
    private List<Cours> coursList = new ArrayList<>();
    
    
    
    public Animateur() {
    }

    public Animateur(String num_tel) {
        this.num_tel = num_tel;
    }

    public Animateur( String id_cin, String nom, String prenom, String prenomPere, String dateNaissance, String sexe,String num_tel,  String num_rue, String designation, String ville, String code_postal, String gouvernorat, String image) {
        super(id_cin, nom, prenom, prenomPere, dateNaissance, sexe,  num_rue, designation, ville, code_postal, gouvernorat, image);
        this.num_tel = num_tel;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(String num_tel) {
        this.num_tel = num_tel;
    }

   
    public boolean add() throws SQLException {
        
        String MyRequest = "insert into animateur (CIN, nom, prenom, prenom_pere , date_naissance , sexe, numero,  numero_rue, designation,ville,code_postal,gouvernorat,image ) values ("+
                "'"+getId_cin()+"'," +
                "'"+getNom()+"'," +
                "'"+getPrenom()+"'," +
                "'"+getPrenomPere()+"'," +
                "'"+getDateNaissance()+"'," +
                "'"+getSexe()+"'," +
                "'"+getNum_tel()+"'," +
               // "'"+getClasse()+"'," +
                "'"+getNum_rue()+"'," +
                "'"+getDesignation()+"'," +
                "'"+getVille()+"'," +
                "'"+getCode_postal()+"'," +
                "'"+getGouvernorat()+"'," +
                "'"+getImage()+"')";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

    
    public boolean delete(String cin) throws SQLException {
        String MyRequest = "delete from animateur "
				+ " where CIN='"+ cin +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

  
    public boolean update() throws SQLException {
        String MyRequest = "update animateur set "+" CIN ='" + this.getId_cin() + "' ,"+
			" nom ='" + this.getNom() + "' ,"+
			" prenom ='" + this.getPrenom() + "' ,"+
                        " prenom_pere ='" + this.getPrenomPere()+ "' ,"+
                        " date_naissance ='" + this.getDateNaissance() + "' ,"+
			" sexe ='" + this.getSexe() + "' ,"+
			" numero ='" + this.getNum_tel() + "' ,"+
                        //" classe ='" + this.getClasse() + "' ,"+
                        " numero_rue ='" + this.getNum_rue() + "' ,"+
                        " designation ='" + this.getDesignation() + "' ,"+
                        " ville ='" + this.getVille() + "' ,"+
                        " code_postal ='" + this.getCode_postal() + "' ,"+
			" gouvernorat ='" + this.getGouvernorat() + "' ,"+
			" image ='" + this.getImage() + "' "+
		" where CIN='"+ this.getId_cin()+"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
    }

    
    public ArrayList<Animateur> lister() throws SQLException {
        ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from animateur";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeAnimateurs.add(new Animateur(rs.getString(1),
					rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                                        rs.getString(12),rs.getString(13)
					
					));
		}
		return listeAnimateurs;
	}
    
    
    
    /*
    public ArrayList<Classe> updateCombo() throws ClassNotFoundException, SQLException
    {
        ArrayList<Classe> listeClasse = new ArrayList<Classe>();
        
        //myConnection = new MyConnection();
         //String requet = " select * from  classe ";
         String MyRequest = "select * from classe";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeClasse.add(new Classe(rs.getString(1)));
		}
		return listeClasse;

    }
    */
    
    
    public ArrayList<Animateur> updateCombo() throws ClassNotFoundException, SQLException
    {
        ArrayList<Animateur> listeAnimateur = new ArrayList<Animateur>();
        
        //myConnection = new MyConnection();
         //String requet = " select * from  classe ";
         String MyRequest = "select CIN from animateur";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeAnimateur.add(new Animateur(rs.getString(1)));
		}
		return listeAnimateur;

    }
    
    
    
    
    public ArrayList<Cours> listercours(String s) throws SQLException {
       // ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from cours,animateur where animateur.classe=classe.nom_classe and nom_classe='"+s+"'";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			coursList.add(new Cours(rs.getString(1),rs.getString(2),rs.getInt(3)));
		}
		return (ArrayList<Cours>) coursList;
	}

   
    public ArrayList<Eleves> listereleves() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    }






  

   

  

	

	
	
	
	
	
	


