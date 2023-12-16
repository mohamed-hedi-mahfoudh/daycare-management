package Model;

import View.Acceuil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cours {
	
    private String code ;
    private String designation;
    //private String id_animateur;
    //private String nom_classe;
    private String comboanim;
    private String comboclasse;
    private int prix;
    private List<Animateur> animateursList = new ArrayList<>();

    public Cours(String code, String designation,int prix) {
        this.code = code;
        this.designation = designation;
        //this.id_animateur = id_animateur;
        //this.nom_classe = nom_classe;
        this.prix=prix;
    }

   
    public Cours() {
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    
    
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

 
    
    
    
    
   

   

    
    public boolean add() throws SQLException {
        
        String MyRequest = "insert into cours (code, designation, prix ) values ("+
                "'"+getCode()+"'," +
                "'"+getDesignation()+"'," +
               // "'"+getId_animateur()+"'," +
              //  "'"+getNom_classe()+ "'," +
                "'"+getPrix()+"')";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

   
    public boolean delete(String code) throws SQLException {
        String MyRequest = "delete from cours "
				+ " where code='"+ code +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;	
    }

    
    public boolean update() throws SQLException {
        String MyRequest = "update cours set "+" code ='" + this.getCode() + "' ,"+
			" designation ='" + this.getDesignation() + "' ,"+
			//" animateur_responsable  ='" + this.getId_animateur() + "' ,"+
                      //  " classe  ='" + this.getNom_classe() + "' ,"+
                        " prix  ='" + this.getPrix()+ "'"+
                " where code='"+ this.getCode() +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
    }


    public ArrayList<Cours> lister() throws SQLException {
        ArrayList<Cours> listeCours = new ArrayList<Cours>();
		String MyRequest = "select * from cours";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeCours.add(new Cours(rs.getString(1),rs.getString(2),rs.getInt(3)));
		}
		return listeCours;
	}
    
    
    public Boolean effecetuer_anim_classe(String cin ,String co,String cl) throws SQLException {
        
		String MyRequest = "insert into anim_classes_cours (cinanim, codecours ,nomclasse  ) values ("+
                "'"+cin+"'," +
                "'"+co+"'," +
                "'"+cl+"')"  ;
               // "'"+getId_animateur()+"'," +
              //  "'"+getNom_classe()+ "'," +
               // "'"+getPrix()+"')";
		if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
	}
    
    
    
    
    
    public ArrayList<Animateur> listeranim(String s) throws SQLException {
       // ArrayList<Animateur> listeAnimateurs = new ArrayList<Animateur>();
		String MyRequest = "select * from animateur,anim_classes_cours,classe where animateur.CIN=anim_classes_cours.cinanim  and classe.nom_classe=anim_classes_cours.nomclasse and codecours='"+s+"'";
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
    
    
    public ArrayList<Classe> listerclasse(String s) throws ClassNotFoundException, SQLException
    {
        ArrayList<Classe> listeClasse = new ArrayList<Classe>();
        
        //myConnection = new MyConnection();
         //String requet = " select * from  classe ";
         String MyRequest = "select nom_classe from anim_classes_cours,classe,cours where cours.code=anim_classes_cours.codecours  and classe.nom_classe=anim_classes_cours.nomclasse and codecours='"+s+"'";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeClasse.add(new Classe(rs.getString(1)));
		}
		return listeClasse;

    }
    
    
}
