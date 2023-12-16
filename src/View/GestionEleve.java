/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AnimateurController;
import Controller.ClasseController;
import Controller.EleveController;
import Model.Animateur;
import static View.GestionAnimateur.test;
import com.gestiongarderie.frame.ConexionBD;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import  Model.*;


/**
 *
 * @author nejib
 */
public class GestionEleve extends javax.swing.JInternalFrame {

   // Connection conn = null;
   // ResultSet rs = null;
   // PreparedStatement ps = null;
    static String test;
     public String sexee;
     private DefaultTableModel model = new DefaultTableModel();
     private String selectedID=null; 
    /**
     * Creates new form GestionEleve
     */
    public GestionEleve() throws SQLException, ClassNotFoundException {
        initComponents();
        RemoveTitleBar();
        BtnGrp.add(RbtnHomme);
       BtnGrp.add(RbtnFemme);
           //   conn = ConexionBD.Conexion();

              
              
              
              remplirJTableeleve();
              setCombo();
      // Affichage();
      // updateCombo();
    }
    void RemoveTitleBar()
    {
        putClientProperty("acc.ispalette",Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }
    
    
    
    /*
    public void Affichage() {
        try {
            String requete = "select * from eleve";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            Table.setModel(DbUtils.resultSetToTableModel(rs));
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }

    }
    */
    
    
    
    
    public void setCombo()
    {
         ClasseController cc = new ClasseController();
         
ArrayList<Classe> liste = null;
        try {
            liste = cc.listerClasse();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
	        for (int i=0;i<liste.size();i++)
	        {
	        Classe currentClasse = liste.get(i);
	        combo.addItem(currentClasse.getNomClasse());
         
                }
    }
    
    
    
    private void remplirJTableeleve() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("ID_Eleve");
		model.addColumn("Nom");
		model.addColumn("Prenom");
		model.addColumn("Prenom_pere");
		model.addColumn("Date Naissance");
		model.addColumn("sexe");
                model.addColumn("Cin_Pere");
                model.addColumn("Num_pere");
                model.addColumn("Prenom_Grand_Pere_pere");
                model.addColumn("Prenom_Grand_Pere_pere");		
                model.addColumn("classe");
                model.addColumn("num_rue");
                model.addColumn("designation");
                model.addColumn("ville");
                model.addColumn("code_postal");
                model.addColumn("gouvernorat");
		model.addColumn("Image");
	           EleveController ec = new EleveController();
	        ArrayList<Eleves> liste = ec.listerEleve();
	        for (int i=0;i<liste.size();i++)
	        {
	        Eleves currentEleve = liste.get(i);
	        model.addRow(new Object[]{
                currentEleve.getId_cin(),
	        currentEleve.getNom(),
                currentEleve.getPrenom(),
	        currentEleve.getPrenomPere(),
	        currentEleve.getDateNaissance().toString(),
	        currentEleve.getSexe(),
                currentEleve.getCin_pere(),
                currentEleve.getNum_pere(),
                currentEleve.getPrenom_grand_pere_pere(),
                currentEleve.getPrenom_grand_pere_mere(),               
	        currentEleve.getClasse(),
                currentEleve.getNum_rue(),
                currentEleve.getDesignation(),
                currentEleve.getVille(),
                currentEleve.getCode_postal(),
                currentEleve.getGouvernorat(),
	        currentEleve.getImage()});
	        }
	        Table.setModel(model);
	}
    
    
    
    
    public void Deplaceeleve() throws ParseException {
       
            
           
int row = Table.getSelectedRow();
            String id = (Table.getModel().getValueAt(row, 0).toString());
            String nom = (Table.getModel().getValueAt(row, 1).toString());
            String prenom = (Table.getModel().getValueAt(row, 2).toString());
            String prenompere = (Table.getModel().getValueAt(row, 3).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 4));
           sexee = (Table.getModel().getValueAt(row, 5).toString());
                String cinpere = (Table.getModel().getValueAt(row, 6).toString());
                String numpere = (Table.getModel().getValueAt(row, 7).toString());
                String prenomgrandperepere = (Table.getModel().getValueAt(row, 8).toString());
                String prenomgrandperemere = (Table.getModel().getValueAt(row, 9).toString());
            String cls = (Table.getModel().getValueAt(row, 10).toString());
            String numrue = (Table.getModel().getValueAt(row, 11).toString());
            String des = (Table.getModel().getValueAt(row, 12).toString());
            String ville = (Table.getModel().getValueAt(row, 13).toString());
            String copdepostal = (Table.getModel().getValueAt(row, 14).toString());
            String gouv = (Table.getModel().getValueAt(row, 15).toString());
            String img = (Table.getModel().getValueAt(row, 16).toString());
            
            
            
                txtid.setText(id);                
                txtnom.setText(nom);
                txtprenom.setText(prenom);
                txtprenompere.setText(prenompere);                
                txtdate.setDate(date);
                
                if (sexee.equals("Masculin")) {
                    RbtnHomme.setSelected(true);
                    
               } else if (sexee.equals("Feminin")) {
                   RbtnFemme.setSelected(true);
                   
               }
                  else
               {
                    RbtnFemme.setSelected(false);
                    RbtnHomme.setSelected(false);
               }
                
                
                txtcinpere.setText(cinpere);  
                txtnumpere.setText(numpere);
                txtpregp_p.setText(prenomgrandperepere);
                txtpregp_m.setText(prenomgrandperemere);
                    
                txtnumpere.setText(numpere);
                combo.setSelectedItem(cls);
                TxtAdresseRue.setText(numrue);   
                TxtAdresseDes.setText(des);   
                TxtAdresseVille.setText(ville);   
                TxtAdresseCode.setText(copdepostal);   
                TxtAdresseGouv.setText(gouv);   
                txtpath.setText(img);  
    
    
    }
    
    
    
    /*
    
    
    int row = Table.getSelectedRow();
            String id = (Table.getModel().getValueAt(row, 0).toString());
            String nom = (Table.getModel().getValueAt(row, 1).toString());
            String prenom = (Table.getModel().getValueAt(row, 2).toString());
            String prenompere = (Table.getModel().getValueAt(row, 3).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 4));
            String sexe = (Table.getModel().getValueAt(row, 5).toString());
                String cinpere = (Table.getModel().getValueAt(row, 6).toString());
                String numpere = (Table.getModel().getValueAt(row, 7).toString());
                String prenomgrandperepere = (Table.getModel().getValueAt(row, 8).toString());
                String prenomgrandperemere = (Table.getModel().getValueAt(row, 9).toString());
            String cls = (Table.getModel().getValueAt(row, 10).toString());
            String numrue = (Table.getModel().getValueAt(row, 11).toString());
            String des = (Table.getModel().getValueAt(row, 12).toString());
            String ville = (Table.getModel().getValueAt(row, 13).toString());
            String copdepostal = (Table.getModel().getValueAt(row, 14).toString());
            String gouv = (Table.getModel().getValueAt(row, 15).toString());
            String img = (Table.getModel().getValueAt(row, 16).toString());
            
            
            
                txtid.setText(id);                
                txtnom.setText(nom);
                txtprenom.setText(prenom);
                txtprenompere.setText(prenompere);                
                txtdate.setDate(date);
                
                if (sexe.equals("Masculin")) {
                    RbtnHomme.setSelected(true);
                    
               } else if (sexe.equals("Feminin")) {
                   RbtnFemme.setSelected(true);
                   
               }
                
                
                txtcinpere.setText(cinpere);  
                txtnumpere.setText(numpere);
                txtpregp_p.setText(prenomgrandperepere);
                txtpregp_m.setText(prenomgrandperemere);
                    
                txtnumpere.setText(numpere);
                combo.setSelectedItem(cls);
                TxtAdresseRue.setText(numrue);   
                TxtAdresseDes.setText(des);   
                TxtAdresseVille.setText(ville);   
                TxtAdresseCode.setText(copdepostal);   
                TxtAdresseGouv.setText(gouv);   
                txtpath.setText(img);   
    
    
    */
    
    public void clear() {
        try {

            txtid.setText("");
            txtnom.setText("");
            txtprenom.setText("");
//            txtns.setDate(null);
            txtprenompere.setText("");
            
            RbtnFemme.setSelected(false);
            RbtnHomme.setSelected(false);
            combo.setSelectedItem(null);
            txtdate.setDate(null);
           
            
//            txtesex.setText("");
//            txtesexe.setText("");
            //txtdate.setText("");
            
            txtcinpere.setText("");
//            txtgsm2.setText("");
            txtnumpere.setText("");
            txtpregp_p.setText("");
            txtpregp_m.setText("");
            
            
            TxtAdresseRue.setText("");
            TxtAdresseDes.setText("");
            TxtAdresseVille.setText("");
            TxtAdresseCode.setText("");
            TxtAdresseGouv.setText("");
            txtpath.setText("");
//            image.setIcon(null);
            ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
    
    public void Deplace() {
        try {

            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  eleve where id_eleve = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("id_eleve");
                txtid.setText(t1);
                String t2 = rs.getString("nom");
                txtnom.setText(t2);
                String t3 = rs.getString("prenom");
                txtprenom.setText(t3);
                String t4 = rs.getString("prenom_pere");
                txtprenompere.setText(t4);
                Date t5 = rs.getDate("date_naissance");
                txtdate.setDate(t5);
                String t = rs.getString("sexe");
//                String vbn = t;
//                txtesex.setText(t);
                if (t.equals("Masculin")) {
                    RbtnHomme.setSelected(true);
                    sexee = "Masculin";
                } else if (t.equals("Feminin")) {
                    RbtnFemme.setSelected(true);
                    sexee = "Feminin";
                }
                
                
                combo.setSelectedItem(rs.getString("classe"));
                
                String t7 = rs.getString("cin_pere");
                txtcinpere.setText(t7);
//                String t8 = rs.getString("adresse_moni");
//                txtpasse.setText(t8);
                
                 String t8 = rs.getString("num_pere");
                 txtcinpere.setText(t8);
                 String t9 = rs.getString("prenom_grand_pere_pere");
                 txtpregp_p.setText(t9);
                 String t10 = rs.getString("prenom_grand_pere_mere");
                 txtpregp_m.setText(t10);
                
                 
                 
                 
                String t11 = rs.getString("numero_rue");
                TxtAdresseRue.setText(t9);
                String t12 = rs.getString("designation");
                TxtAdresseDes.setText(t9);
                String t13 = rs.getString("ville");
                TxtAdresseVille.setText(t10);
                String t14 = rs.getString("code_postal");
                TxtAdresseCode.setText(t11);
                String t15 = rs.getString("gouvernorat");
                TxtAdresseGouv.setText(t12);
//                 if (t9.equals("Code")) {
//                    Radiocode.setSelected(true);
//                    types = "Code";
//                } else if (t9.equals("Conduite")) {
//                    Radioconduite.setSelected(true);
//                    types = "Conduite";
//                }
                
//                byte[] imagedata =rs.getBytes("image");
//                Format = new ImageIcon(imagedata);
//                image.setIcon(Format);
                String t16 = rs.getString("image");
                System.out.println(t10);
                if (t13.equals("")) {
                      ImageIcon img202 = new ImageIcon(getClass().getResource("file_image_1.png"));
        image.setIcon(img202);
                } else  {
                   image.setIcon(new ImageIcon(t10));
                   txtpath.setText(t10);
                }
//                image.setIcon(new ImageIcon(t10));
            }
ps.close();
                rs.close();
        } catch (Exception e) {
            System.out.println(e);
            
        }finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }
    }
    
   */
    /*
    public void updateCombo()
    {
         String requet = " select * from  classe ";
         try
         {
             ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            while(rs.next())
            {
                combo.addItem(rs.getString("nom_classe"));
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }

    }
    */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnGrp = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtprenompere = new javax.swing.JTextField();
        txtpregp_m = new javax.swing.JTextField();
        txtcinpere = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtpregp_p = new javax.swing.JTextField();
        BtnImage = new javax.swing.JButton();
        RbtnHomme = new javax.swing.JRadioButton();
        RbtnFemme = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        txtdate = new com.toedter.calendar.JDateChooser();
        combo = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtnumpere = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        TxtAdresseCode = new javax.swing.JTextField();
        TxtAdresseRue = new javax.swing.JTextField();
        TxtAdresseDes = new javax.swing.JTextField();
        TxtAdresseVille = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        TxtAdresseGouv = new javax.swing.JTextField();
        txtpath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnAjoute = new javax.swing.JButton();
        BtnModif = new javax.swing.JButton();
        BtnSup = new javax.swing.JButton();
        BtnImp = new javax.swing.JButton();
        BtnEnregistrer = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Génerale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setText("Nom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel4.setText("Prénom");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel5.setText("Prénom Pére");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setText("Prénom Grand Pére(Pére)");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel7.setText("Prénom Grand Pére(Mére)");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jLabel8.setText("CIN Pére");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel9.setText("Classe");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });
        jPanel1.add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 140, -1));

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 140, -1));
        jPanel1.add(txtprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, -1));
        jPanel1.add(txtprenompere, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, -1));
        jPanel1.add(txtpregp_m, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 140, -1));

        txtcinpere.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcinpereKeyTyped(evt);
            }
        });
        jPanel1.add(txtcinpere, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 140, -1));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 130, -1, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 112, -1, -1));
        jPanel1.add(txtpregp_p, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 140, -1));

        BtnImage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnImage.setText("Selectioner Une Image");
        BtnImage.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnImage.setContentAreaFilled(false);
        BtnImage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnImageMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnImageMouseExited(evt);
            }
        });
        BtnImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImageActionPerformed(evt);
            }
        });
        jPanel1.add(BtnImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 170, 50));

        RbtnHomme.setText("Homme");
        RbtnHomme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnHommeActionPerformed(evt);
            }
        });
        jPanel1.add(RbtnHomme, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        RbtnFemme.setText("Femme");
        RbtnFemme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnFemmeActionPerformed(evt);
            }
        });
        jPanel1.add(RbtnFemme, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        jLabel14.setText("Sexe");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel15.setText("Anneé Naissance");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file_image_1.png"))); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 160, 130));

        txtdate.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, -1));

        jPanel1.add(combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 140, -1));

        jLabel17.setText("Numéro Pére");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        txtnumpere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumpereActionPerformed(evt);
            }
        });
        txtnumpere.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumpereKeyTyped(evt);
            }
        });
        jPanel1.add(txtnumpere, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 140, -1));

        jLabel19.setText("Numéro Rue");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jLabel20.setText("Désignation");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel21.setText("Ville");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel22.setText("Code Postal");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, -1));

        TxtAdresseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAdresseCodeActionPerformed(evt);
            }
        });
        TxtAdresseCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAdresseCodeKeyTyped(evt);
            }
        });
        jPanel1.add(TxtAdresseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 120, -1));

        TxtAdresseRue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAdresseRueKeyTyped(evt);
            }
        });
        jPanel1.add(TxtAdresseRue, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 120, -1));
        jPanel1.add(TxtAdresseDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 120, -1));

        TxtAdresseVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAdresseVilleActionPerformed(evt);
            }
        });
        jPanel1.add(TxtAdresseVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 120, -1));

        jLabel23.setText("Gouvernorat");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));
        jPanel1.add(TxtAdresseGouv, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 120, -1));

        txtpath.setEditable(false);
        jPanel1.add(txtpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 530, 500));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Eleves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        Table.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        Table.setAutoscrolls(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 450, 170));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/search.png"))); // NOI18N
        jLabel13.setText("Recherche Par Nom");

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/search.png"))); // NOI18N
        jLabel12.setText("Recherche Par ID");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 450, 110));

        jPanel4.setBackground(new java.awt.Color(41, 75, 124));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gestion Eleves");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel16)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        BtnAjoute.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAjoute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file.png"))); // NOI18N
        BtnAjoute.setText("Vider Les Champs");
        BtnAjoute.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnAjoute.setContentAreaFilled(false);
        BtnAjoute.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAjoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAjouteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAjouteMouseExited(evt);
            }
        });
        BtnAjoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAjouteActionPerformed(evt);
            }
        });

        BtnModif.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnModif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file (2).png"))); // NOI18N
        BtnModif.setText("Modifier");
        BtnModif.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnModif.setContentAreaFilled(false);
        BtnModif.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnModif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnModifMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnModifMouseExited(evt);
            }
        });
        BtnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModifActionPerformed(evt);
            }
        });
        BtnModif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BtnModifKeyTyped(evt);
            }
        });

        BtnSup.setBackground(new java.awt.Color(255, 255, 255));
        BtnSup.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnSup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file (1).png"))); // NOI18N
        BtnSup.setText("Supprimer");
        BtnSup.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnSup.setContentAreaFilled(false);
        BtnSup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnSupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnSupMouseExited(evt);
            }
        });
        BtnSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSupActionPerformed(evt);
            }
        });

        BtnImp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/printer.png"))); // NOI18N
        BtnImp.setText("Imprimer");
        BtnImp.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnImp.setContentAreaFilled(false);
        BtnImp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnImp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnImpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnImpMouseExited(evt);
            }
        });
        BtnImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImpActionPerformed(evt);
            }
        });

        BtnEnregistrer.setBackground(new java.awt.Color(255, 255, 255));
        BtnEnregistrer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnEnregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/save.png"))); // NOI18N
        BtnEnregistrer.setText("Ajouter");
        BtnEnregistrer.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 2, 1, new java.awt.Color(0, 0, 0)));
        BtnEnregistrer.setContentAreaFilled(false);
        BtnEnregistrer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEnregistrer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEnregistrerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEnregistrerMouseExited(evt);
            }
        });
        BtnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnregistrerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnSup, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(BtnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BtnAjoute, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAjoute, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModif, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnSup, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(BtnImp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(BtnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 450, 190));

        setBounds(0, 0, 1050, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void BtnImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImageMouseEntered
        // TODO add your handling code here:
        BtnImage.setForeground(Color.white);
        BtnImage.setContentAreaFilled(true);
        BtnImage.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnImageMouseEntered

    private void BtnImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImageMouseExited
        // TODO add your handling code here:
        BtnImage.setContentAreaFilled(false);
        BtnImage.setForeground(Color.black);
    }//GEN-LAST:event_BtnImageMouseExited

    private void BtnImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImageActionPerformed
        // TODO add your handling code here:
         String filename= null;
      String path = null;
        //imagess();
        try {

            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choisir une image png");
            chooser.setApproveButtonText("Ajouter une image");
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            filename = f.getAbsolutePath();
            path = (filename);
            image.setIcon(new ImageIcon(path));
            txtpath.setText(path);
            
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null," Veuiler choisir une image ");;
        }
    }//GEN-LAST:event_BtnImageActionPerformed

    private void RbtnFemmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnFemmeActionPerformed
        // TODO add your handling code here:
        sexee = "Feminin";
    }//GEN-LAST:event_RbtnFemmeActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtnumpereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumpereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumpereActionPerformed

    private void TxtAdresseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAdresseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAdresseCodeActionPerformed

    private void BtnAjouteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAjouteMouseEntered
        // TODO add your handling code here:
        BtnAjoute.setForeground(Color.white);
        BtnAjoute.setContentAreaFilled(true);
        BtnAjoute.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnAjouteMouseEntered

    private void BtnAjouteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAjouteMouseExited
        // TODO add your handling code here:
        BtnAjoute.setContentAreaFilled(false);
        BtnAjoute.setForeground(Color.black);
    }//GEN-LAST:event_BtnAjouteMouseExited

    private void BtnSupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupMouseEntered
        // TODO add your handling code here:
        BtnSup.setForeground(Color.white);
        BtnSup.setContentAreaFilled(true);
        BtnSup.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnSupMouseEntered

    private void BtnSupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupMouseExited
        // TODO add your handling code here:
        BtnSup.setContentAreaFilled(false);
        BtnSup.setForeground(Color.black);
    }//GEN-LAST:event_BtnSupMouseExited

    private void BtnImpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImpMouseEntered
        // TODO add your handling code here:
        BtnImp.setForeground(Color.white);
        BtnImp.setContentAreaFilled(true);
        BtnImp.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnImpMouseEntered

    private void BtnImpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImpMouseExited
        // TODO add your handling code here:
        BtnImp.setContentAreaFilled(false);
        BtnImp.setForeground(Color.black);
    }//GEN-LAST:event_BtnImpMouseExited

    private void BtnImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImpActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Liste des Eleves");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_BtnImpActionPerformed

    private void BtnAjouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouteActionPerformed
        // TODO add your handling code here:
         clear();
       
    }//GEN-LAST:event_BtnAjouteActionPerformed

    private void TxtAdresseVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAdresseVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAdresseVilleActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
         
        
        selectedID = (String)Table.getValueAt(Table.getSelectedRow(),
						0);
        
        try {
            // TODO add your handling code here:
            Deplaceeleve();
        } catch (ParseException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_TableMouseClicked

    private void RbtnHommeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnHommeActionPerformed
        // TODO add your handling code here:
        sexee = "Masculin";
    }//GEN-LAST:event_RbtnHommeActionPerformed

    private void BtnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupActionPerformed
        // TODO add your handling code here:
        /*
        try {
            if(JOptionPane.showConfirmDialog(null,"attention vous devez suprimer un eleve,est ce que tu es sur?","supprimer eleve", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
{
    String requete="delete from eleve where id_eleve = '" + txtid.getText() + "'";
    ps = conn.prepareStatement(requete);

                ps.execute();
 ps.close();
                rs.close();
}
            
            
        } catch (Exception e)
        {
            
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "erreur de supprimer \n" + e.getMessage());
            
        }
        
        finally 
        {
            try 
            {
                ps.close();
                rs.close();
            } catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null, "erreur BD");
                    }
        }
        Affichage();
        
        
        */
        
        
        
        
        
        
        
        if(selectedID == null)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						EleveController ac = new EleveController();
						if(ac.deleteEleve(selectedID))
						{
							JOptionPane.showMessageDialog(null,
									"Eleve supprimé avec succès");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage());
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage());
					}
				}
                                
        try {
            remplirJTableeleve();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_BtnSupActionPerformed

    private void BtnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnregistrerActionPerformed

        
         String cl = (String) combo.getSelectedItem();
        
         
         if(txtid.getText().isEmpty() || txtnom.getText().isEmpty() ||txtprenom.getText().isEmpty() || txtprenompere.getText().isEmpty() ||txtdate.getDate().toString().isEmpty() || BtnGrp.isSelected(null) ||txtnumpere.getText().isEmpty() || TxtAdresseRue.getText().isEmpty() ||TxtAdresseDes.getText().isEmpty() ||TxtAdresseVille.getText().isEmpty() ||TxtAdresseCode.getText().isEmpty() ||TxtAdresseGouv.getText().isEmpty() ||txtpath.getText().isEmpty() ||txtpregp_p.getText().isEmpty()||txtpregp_m.getText().isEmpty() ||txtcinpere.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Eleve non ajouté "
							+ " il y'a un chmap vide");
        }
        else if(txtnumpere.getText().toString().length()!=8 || TxtAdresseCode.getText().toString().length()!=4 )
        {
            JOptionPane.showMessageDialog(null, "Eleev non ajouté \n"
							+ "il faut nombre de chifre numero=8 et nombre de chifre code postale =4");
        }
         else
        {
            try {
			//instancier un eleve à ajouter dans la base d données:
            
				Eleves neweleve = new Eleves();
				neweleve.setId_cin(txtid.getText());
				neweleve.setNom(txtnom.getText());
				neweleve.setPrenom(txtprenom.getText());
                                neweleve.setPrenomPere(txtprenompere.getText());
                                
                             
      
      String d = ((JTextField) txtdate.getDateEditor().getUiComponent()).getText();
      
                                // Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
                                //t.setText(d);
                                
                                neweleve.setDateNaissance(d);
                                
                              //  newAnimateur.setDateNaissance(date1);    
                                
                                neweleve.setSexe(sexee);
                                neweleve.setCin_pere(txtcinpere.getText());
                                neweleve.setNum_pere(txtnumpere.getText());
                                neweleve.setPrenom_grand_pere_pere(txtpregp_p.getText());
                                neweleve.setPrenom_grand_pere_pere(txtpregp_m.getText());                               
                                neweleve.setClasse(cl);
                                neweleve.setNum_rue(TxtAdresseRue.getText());
                                neweleve.setDesignation(TxtAdresseDes.getText());
				neweleve.setVille(TxtAdresseVille.getText());
				neweleve.setCode_postal(TxtAdresseCode.getText());				
				neweleve.setGouvernorat(TxtAdresseGouv.getText());
				neweleve.setImage(txtpath.getText());
				


                    //instancier le controleur:
                                
                                
				EleveController ec = new EleveController();
				if(ec.addEleve(neweleve));
				{
					JOptionPane.showMessageDialog(null, "Eleve ajouté "
							+ " avec succès.");
				}
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Eleve non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Eleve non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
        try {
            remplirJTableeleve();
            
            
            //String d=txtdate.getDate().toString();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         
         
        
        
        
        

    }//GEN-LAST:event_BtnEnregistrerActionPerformed

    private void BtnEnregistrerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEnregistrerMouseExited
        // TODO add your handling code here:
        BtnEnregistrer.setContentAreaFilled(false);
        BtnEnregistrer.setForeground(Color.black);
    }//GEN-LAST:event_BtnEnregistrerMouseExited

    private void BtnEnregistrerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEnregistrerMouseEntered
        // TODO add your handling code here:
        BtnEnregistrer.setForeground(Color.white);
        BtnEnregistrer.setContentAreaFilled(true);
        BtnEnregistrer.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnEnregistrerMouseEntered

    private void BtnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifActionPerformed
        // TODO add your handling code here:
        
        /*
        String cl = (String) combo.getSelectedItem();
        String requete = "update eleve set id_eleve =?,nom =?,prenom=?,prenom_pere =?,date_naissance =?,sexe =?,cin_pere =?,num_pere=?,prenom_grand_pere_pere=?,prenom_grand_pere_mere =?,classe =?,numero_rue=?,designation=?,ville =?,code_postal =?,gouvernorat =?,image =? where  id_eleve ='" +txtid.getText()+ "'";
        try {
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtid.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, txtprenompere.getText());
            ps.setString(5, ((JTextField) txtdate.getDateEditor().getUiComponent()).getText());
            ps.setString(6, sexee);
            ps.setString(7, txtcinpere.getText());
            ps.setString(8, txtnumpere.getText());
            ps.setString(9, txtpregp_p.getText());
            ps.setString(10, txtpregp_m.getText());
            ps.setString(11, cl);
            ps.setString(12, TxtAdresseRue.getText());
            ps.setString(13, TxtAdresseDes.getText());
            ps.setString(14, TxtAdresseVille.getText());
            ps.setString(15, TxtAdresseCode.getText());
            ps.setString(16, TxtAdresseGouv.getText());
            ps.setString(17, txtpath.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modification avec succès");
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        finally {

            try {
                ps.close();
                rs.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "erreur BD");
            }
        }

        Affichage();
        
        */
        
        
        
        
        
        
         String d = ((JTextField) txtdate.getDateEditor().getUiComponent()).getText();
      
                                // Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
                               
        
        
        
         String cl = (String) combo.getSelectedItem();
        
         
         
          if(txtid.getText().isEmpty() || txtnom.getText().isEmpty() ||txtprenom.getText().isEmpty() || txtprenompere.getText().isEmpty() ||txtdate.getDate().toString().isEmpty() || BtnGrp.isSelected(null) ||txtnumpere.getText().isEmpty() || TxtAdresseRue.getText().isEmpty() ||TxtAdresseDes.getText().isEmpty() ||TxtAdresseVille.getText().isEmpty() ||TxtAdresseCode.getText().isEmpty() ||TxtAdresseGouv.getText().isEmpty() ||txtpath.getText().isEmpty() ||txtpregp_p.getText().isEmpty()||txtpregp_m.getText().isEmpty() ||txtcinpere.getText().isEmpty())
        {
            
            JOptionPane.showMessageDialog(null, "Eleve non ajouté "
							+ " il y'a un chmap vide");
        }
        else if(txtnumpere.getText().toString().length()!=8 || TxtAdresseCode.getText().toString().length()!=4 )
        {
            JOptionPane.showMessageDialog(null, "Eleev non ajouté \n"
							+ "il faut nombre de chifre numero=8 et nombre de chifre code postale =4");
        }
         else
        {
         
        try {
			//instancier un animateur à ajouter dans la base d données:
            
				Eleves ele = new Eleves();
				ele.setId_cin(txtid.getText());
				ele.setNom(txtnom.getText());
				ele.setPrenom(txtprenom.getText());
                                ele.setPrenomPere(txtprenompere.getText());
                                ele.setDateNaissance(d);
				ele.setSexe(sexee);
				ele.setCin_pere(txtcinpere.getText());
                                ele.setNum_pere(txtnumpere.getText());
                                ele.setPrenom_grand_pere_pere(txtpregp_p.getText());
                                ele.setPrenom_grand_pere_mere(txtpregp_m.getText());
                                ele.setClasse(cl);
                                ele.setNum_rue(TxtAdresseRue.getText());
				ele.setDesignation(TxtAdresseDes.getText());
				ele.setVille(TxtAdresseVille.getText());
                                ele.setCode_postal(TxtAdresseCode.getText());
                                ele.setGouvernorat(TxtAdresseGouv.getText());
                                ele.setImage(cl);
                                
                             
				


                    //instancier le controleur:
                                
                                
				EleveController ec = new EleveController();
                                
                               
                                
                                    if(ec.updateEleve(ele))
				{
					JOptionPane.showMessageDialog(null, "Eleve modifié "
							+ " avec succès.");
				}
                                
				
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Cours non modifié"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Cours non modifié"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
         try {
             remplirJTableeleve();
         } catch (SQLException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
        
        
        
        
        
        

    }//GEN-LAST:event_BtnModifActionPerformed

    private void BtnModifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModifMouseExited
        // TODO add your handling code here:
        BtnModif.setContentAreaFilled(false);
        BtnModif.setForeground(Color.black);
    }//GEN-LAST:event_BtnModifMouseExited

    private void BtnModifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModifMouseEntered
        // TODO add your handling code here:
        BtnModif.setForeground(Color.white);
        BtnModif.setContentAreaFilled(true);
        BtnModif.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnModifMouseEntered

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtidKeyTyped

    private void TxtAdresseRueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAdresseRueKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtAdresseRueKeyTyped

    private void TxtAdresseCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAdresseCodeKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtAdresseCodeKeyTyped

    private void txtcinpereKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcinpereKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtcinpereKeyTyped

    private void txtnumpereKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumpereKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtnumpereKeyTyped

    private void BtnModifKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnModifKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_BtnModifKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjoute;
    private javax.swing.JButton BtnEnregistrer;
    private javax.swing.ButtonGroup BtnGrp;
    private javax.swing.JButton BtnImage;
    private javax.swing.JButton BtnImp;
    private javax.swing.JButton BtnModif;
    private javax.swing.JButton BtnSup;
    private javax.swing.JRadioButton RbtnFemme;
    private javax.swing.JRadioButton RbtnHomme;
    private javax.swing.JTable Table;
    private javax.swing.JTextField TxtAdresseCode;
    private javax.swing.JTextField TxtAdresseDes;
    private javax.swing.JTextField TxtAdresseGouv;
    private javax.swing.JTextField TxtAdresseRue;
    private javax.swing.JTextField TxtAdresseVille;
    private javax.swing.JComboBox combo;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField txtcinpere;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnumpere;
    private javax.swing.JTextField txtpath;
    private javax.swing.JTextField txtpregp_m;
    private javax.swing.JTextField txtpregp_p;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtprenompere;
    // End of variables declaration//GEN-END:variables
}
