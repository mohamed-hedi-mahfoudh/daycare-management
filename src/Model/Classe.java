package Model;

import View.Acceuil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Classe {

	 private String nomClasse;
         private List<Animateur> animateursList = new ArrayList<>();
	 private List<Eleves> elevesList = new ArrayList<>();
	 private List<Cours> coursList = new ArrayList<>();

    public Classe() {
    }

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public List<Animateur> getAnimateursList() {
        return animateursList;
    }

    public void setAnimateursList(List<Animateur> animateursList) {
        this.animateursList = animateursList;
    }

    public List<Eleves> getElevesList() {
        return elevesList;
    }

    public void setElevesList(List<Eleves> elevesList) {
        this.elevesList = elevesList;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

	 
    
    
    
    
    public boolean add() throws SQLException {
        
        String MyRequest = "insert into classe (nom_classe ) values ("+"'"+getNomClasse()+ "')";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

    
    public boolean delete(String nom_classe) throws SQLException {
        String MyRequest = "delete from classe "
				+ " where nom_classe='"+ nom_classe +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

  /*
    public boolean update() throws SQLException {
        String MyRequest = "update classe set "+" nom_classe ='" + this.getNomClasse() + "' ,"+
			
			" where CIN='"+ this.getId_cin() +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
    }
    */

    /*
    public ArrayList<Classe> lister() throws SQLException {
        ArrayList<Classe> listeClasses = new ArrayList<Classe>();
		String MyRequest = "select nom_classe from classe";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeClasses.add(new Classe(rs.getString(1)
					
					));
		}
		return listeClasses;
	}
    */
    
    
    
    
    
    
	    

		
public ArrayList<Classe> lister() throws ClassNotFoundException, SQLException
    {
        ArrayList<Classe> listeClasse = new ArrayList<Classe>();
        
        //myConnection = new MyConnection();
         //String requet = " select * from  classe ";
         String MyRequest = "select nom_classe from classe";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeClasse.add(new Classe(rs.getString(1)));
		}
		return listeClasse;

    }



public ArrayList<Animateur> listeranim(String s) throws SQLException {
       // ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from animateur,anim_classes_cours,classe where animateur.CIN=anim_classes_cours.cinanim  and classe.nom_classe=anim_classes_cours.nomclasse and nom_classe='"+s+"'";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			animateursList.add(new Animateur(rs.getString(1),
					rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                                        rs.getString(12),rs.getString(13)
					
					));
		}
		return (ArrayList<Animateur>) animateursList;
	}







		
public ArrayList<Eleves> listereleve(String s) throws SQLException {
       // ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from eleve,classe where eleve.classe=classe.nom_classe and nom_classe='"+s+"'";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			elevesList.add(new Eleves(rs.getString(1),
					rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                                        rs.getString(12),rs.getString(13),rs.getString(14),
                                        rs.getString(15),rs.getString(16),rs.getString(17)
					
					));
		}
		return (ArrayList<Eleves>) elevesList;
	}


public ArrayList<Cours> listercours(String s) throws SQLException {
       // ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from cours,anim_classes_cours,classe where cours.code=anim_classes_cours.codecours  and classe.nom_classe=anim_classes_cours.nomclasse and nom_classe='"+s+"'";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			coursList.add(new Cours(rs.getString(1),rs.getString(2),rs.getInt(3)));
		}
		return (ArrayList<Cours>) coursList;
	}

    

}
