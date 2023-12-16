package Model;


import View.Acceuil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Eleves extends Personne{
    String cin_pere;
    String num_pere;
    String prenom_grand_pere_pere;
    String prenom_grand_pere_mere;
    String classe;


    public Eleves() {
    }
    
    
    

    public Eleves(String id_cin, String nom, String prenom, String prenomPere, String dateNaissance, String sexe,String cin_pere,String num_pere,String prenom_grand_pere_pere,String prenom_grand_pere_mere, String classe, String num_rue, String designation, String ville, String code_postal, String gouvernorat, String image) {
        super(id_cin, nom, prenom, prenomPere, dateNaissance, sexe,  num_rue, designation, ville, code_postal, gouvernorat, image);
        this.cin_pere=cin_pere;
        this.num_pere=cin_pere;
        this.prenom_grand_pere_pere=cin_pere;
        this.prenom_grand_pere_mere=cin_pere;
        this.classe=classe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    
    

    
    
    
    
    public String getCin_pere() {
        return cin_pere;
    }

    public void setCin_pere(String cin_pere) {
        this.cin_pere = cin_pere;
    }

    public String getNum_pere() {
        return num_pere;
    }

    public void setNum_pere(String num_pere) {
        this.num_pere = num_pere;
    }

    public String getPrenom_grand_pere_pere() {
        return prenom_grand_pere_pere;
    }

    public void setPrenom_grand_pere_pere(String prenom_grand_pere_pere) {
        this.prenom_grand_pere_pere = prenom_grand_pere_pere;
    }

    public String getPrenom_grand_pere_mere() {
        return prenom_grand_pere_mere;
    }

    public void setPrenom_grand_pere_mere(String prenom_grand_pere_mere) {
        this.prenom_grand_pere_mere = prenom_grand_pere_mere;
    }
  
    
    
    
    
    
    

   
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    public boolean add() throws SQLException {
        String MyRequest = "insert into eleve (	id_eleve , nom , prenom , prenom_pere , date_naissance , sexe, CIN_pere , num_pere , prenom_grand_pere_pere , prenom_grand_pere_mere , classe , numero_rue , designation , ville , code_postal , gouvernorat , image ) values ("+
                "'"+getId_cin()+"'," +
                "'"+getNom()+"'," +
                "'"+getPrenom()+"'," +
                "'"+getPrenomPere()+"'," +
                "'"+getDateNaissance()+"'," +
                "'"+getSexe()+"'," +
                "'"+getCin_pere()+"'," +
                "'"+getNum_pere()+"'," +
                "'"+getPrenom_grand_pere_pere()+"'," +
                "'"+getPrenom_grand_pere_mere()+"'," +
                "'"+getClasse()+"'," +
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

    
    public boolean delete(String id) throws SQLException {
        String MyRequest = "delete from eleve "
				+ " where id_eleve='"+ id +"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
    }

   
    public boolean update() throws SQLException {
        String MyRequest = "update eleve set "+" id_eleve  ='" + this.getId_cin() + "' ,"+
			" nom ='" + this.getNom() + "' ,"+
			" prenom  ='" + this.getPrenom() + "' ,"+
                        " prenom_pere  ='" + this.getPrenomPere() + "' ,"+
                        " date_naissance ='" + this.getDateNaissance() + "' ,"+
			" sexe  ='" + this.getSexe() + "' ,"+
                        " CIN_pere  ='" + this.getCin_pere() + "' ,"+
                        " num_pere ='" + this.getNum_pere() + "' ,"+
			" prenom_grand_pere_pere  ='" + this.getPrenom_grand_pere_pere() + "' ,"+
                        " prenom_grand_pere_mere  ='" + this.getPrenom_grand_pere_mere() + "' ,"+
                        " classe  ='" + this.getClasse() + "' ,"+
			" numero_rue  ='" + this.getNum_rue() + "' ,"+
                        " designation  ='" + this.getDesignation() + "' ,"+
                        " ville ='" + this.getVille() + "' ,"+
			" code_postal  ='" + this.getCode_postal() + "' ,"+
                        " gouvernorat  ='" + this.getGouvernorat() + "' ,"+
                        " image  ='" + this.getImage() + "' "+
                " where id_eleve='"+ this.getId_cin()+"'";
			if(Acceuil.myConnection.executeUpdate(MyRequest)==0)
				return false;
			else
				return true;
    }

    
    
    
    

    
    public ArrayList<Eleves> listerele() throws SQLException {
         ArrayList<Eleves> listeeleve = new ArrayList<Eleves>();
		String MyRequest = "select * from eleve";
		ResultSet rs = Acceuil.myConnection.executeQuery(MyRequest);
		
		while(rs.next())
		{
			listeeleve.add(new Eleves(rs.getString(1),
					rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
                                        rs.getString(12),rs.getString(13),rs.getString(14),
                                        rs.getString(15),rs.getString(16),rs.getString(17)
					
					));
		}
		return listeeleve;
    }
    

   
   
	
	
	
	
	
	
}
