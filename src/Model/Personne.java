package Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public abstract class  Personne {
	private String id_cin;
	private String nom;
	private String prenom;
	private String prenomPere;
        private String dateNaissance ;
        private String sexe;
        //private String classe;
        private String num_rue;
        private String designation;
        private String ville;
        private String code_postal;
        private String gouvernorat;
        private String image;

    public Personne() {
    }
    
    
      


    public Personne(String id_cin, String nom, String prenom, String prenomPere, String dateNaissance, String sexe,  String num_rue, String designation, String ville, String code_postal, String gouvernorat, String image) {
        this.id_cin = id_cin;
        this.nom = nom;
        this.prenom = prenom;
        this.prenomPere = prenomPere;
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
       // this.classe = classe;
        this.num_rue = num_rue;
        this.designation = designation;
        this.ville = ville;
        this.code_postal = code_postal;
        this.gouvernorat = gouvernorat;
        this.image = image;
    }

    public String getId_cin() {
        return id_cin;
    }

    public void setId_cin(String id_cin) {
        this.id_cin = id_cin;
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

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
/*
    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
*/
    public String getNum_rue() {
        return num_rue;
    }

    public void setNum_rue(String num_rue) {
        this.num_rue = num_rue;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


        
        
	
       
	

	
		

}
