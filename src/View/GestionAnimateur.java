/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.AnimateurController;
import Controller.ClasseController;
import Controller.CoursController;
import  Model.*;


import com.gestiongarderie.frame.ConexionBD;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




/**
 *
 * @author nejib
 */
public class GestionAnimateur extends javax.swing.JInternalFrame {
    /*
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    */
    
    private String selectedCIN=null; 
    
    private DefaultTableModel model = new DefaultTableModel();
    static String test;
     public String sexee;
     public String comboclasse;

    /**
     * Creates new form GestionAnimateur
     */
    public GestionAnimateur() throws SQLException, ClassNotFoundException {
        
        initComponents();

        RemoveTitleBar();
       // Classe c =new Classe();
       
        BtnGrp.add(RbtnHomme);
       BtnGrp.add(RbtnFemme);
       //conn = ConexionBD.Conexion();
        //Affichage();
       remplirJTableanim();
       //c.updateCombo();
      // setCombo();
        //updateCombo();
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
            String requete = "select * from animateur";
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
    
    
    
    
    
    private void remplirJTableanim() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("CIN");
		model.addColumn("Nom");
		model.addColumn("Prenom");
		model.addColumn("Prenom_pere");
		model.addColumn("Date Naissance");
		model.addColumn("sexe");
		model.addColumn("Num_tel");
                //model.addColumn("classe");
                model.addColumn("num_rue");
                model.addColumn("designation");
                model.addColumn("ville");
                model.addColumn("code_postal");
                model.addColumn("gouvernorat");
		model.addColumn("Image");
	        AnimateurController C = new AnimateurController();
	        ArrayList<Animateur> liste = C.listerAnimateur();
	        for (int i=0;i<liste.size();i++)
	        {
	        Animateur currentAnimateur = liste.get(i);
	        model.addRow(new Object[]{currentAnimateur.getId_cin(),
	        currentAnimateur.getNom(), currentAnimateur.getPrenom(),
	        currentAnimateur.getPrenomPere(),
	        currentAnimateur.getDateNaissance().toString(),
	        currentAnimateur.getSexe(),
                currentAnimateur.getNum_tel(),
	        //currentAnimateur.getClasse(),
                currentAnimateur.getNum_rue(),
                currentAnimateur.getDesignation(),
                currentAnimateur.getVille(),
                currentAnimateur.getCode_postal(),
                currentAnimateur.getGouvernorat(),
	        currentAnimateur.getImage()});
	        }
	        Table.setModel(model);
	}
    
    
    /*
    public void Deplace() {
        try {

            int row = Table.getSelectedRow();
            this.test = (Table.getModel().getValueAt(row, 0).toString());
            String requet = " select * from  animateur where CIN = '" + test + "' ";
            ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();

            if (rs.next()) {
                String t1 = rs.getString("CIN");
                txtcin.setText(t1);
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
            
                
                String t7 = rs.getString("numero");
                txtnum.setText(t7);
//                String t8 = rs.getString("adresse_moni");
//                txtpasse.setText(t8);
                
                 String t8 = rs.getString("numero_rue");
                TxtAdresseRue.setText(t8);
                String t9 = rs.getString("designation");
                TxtAdresseDes.setText(t9);
                String t10 = rs.getString("ville");
                TxtAdresseVille.setText(t10);
                String t11 = rs.getString("code_postal");
                TxtAdresseCode.setText(t11);
                String t12 = rs.getString("gouvernorat");
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
                String t13 = rs.getString("image");
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
    
    
    
    
    
    public void Deplace() throws ParseException {
       
            
           

            int row = Table.getSelectedRow();
            String cin = (Table.getModel().getValueAt(row, 0).toString());
            String nom = (Table.getModel().getValueAt(row, 1).toString());
            String prenom = (Table.getModel().getValueAt(row, 2).toString());
            String prenompere = (Table.getModel().getValueAt(row, 3).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(row, 4));
            sexee = (Table.getModel().getValueAt(row, 5).toString());
            String numtel = (Table.getModel().getValueAt(row, 6).toString());
            //String cls = (Table.getModel().getValueAt(row, 7).toString());
            String numrue = (Table.getModel().getValueAt(row, 7).toString());
            String des = (Table.getModel().getValueAt(row, 8).toString());
            String ville = (Table.getModel().getValueAt(row, 9).toString());
            String copdepostal = (Table.getModel().getValueAt(row, 10).toString());
            String gouv = (Table.getModel().getValueAt(row, 11).toString());
            String img = (Table.getModel().getValueAt(row, 12).toString());
            
            

            
                
                txtcin.setText(cin);                
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
                txtnum.setText(numtel);
                //combo.setSelectedItem(cls);
                TxtAdresseRue.setText(numrue);   
                TxtAdresseDes.setText(des);   
                TxtAdresseVille.setText(ville);   
                TxtAdresseCode.setText(copdepostal);   
                TxtAdresseGouv.setText(gouv);   
                txtpath.setText(img);   
                
                
                //comboanim.setSelectedItem(rs.getString("animateur_responsable"));
               // comboclasse.setSelectedItem(rs.getString("classe"));
                
               // String t3 = rs.getString("animateur_responsable");
                //txtprenom.setText(t3);
               

                

            
    
    
    }
    
    
    
    
    public void clear() {
        try {

            txtcin.setText("");
            txtnom.setText("");
            txtprenom.setText("");
//            txtns.setDate(null);
            txtprenompere.setText("");
             txtdate.setDate(null);

//            txtesex.setText("");
//            txtesexe.setText("");
            //txtdate.setText("");
            RbtnFemme.setSelected(false);
            RbtnHomme.setSelected(false);
           // combo.setSelectedItem(null);
            txtdate.setDate(null);
            txtnum.setText("");
//            txtgsm2.setText("");
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
    
    /*
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
    */
    
    /*
    public void imagess() {
        ConexionBD v = new ConexionBD();
        v.filen();
        String vpath = v.getp();
        try {
        if (vpath == null) {

        } else {
            image.setIcon(new ImageIcon(vpath));
            txtpath.setText(vpath);

            
//                File image = new File(vpath);
//                FileInputStream fs = new FileInputStream(image);
//                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                byte[] b = new byte[1024];
//                for (int re; (re = fs.read(b)) != -1;) {
//                    bs.write(b, 0, re);
//
//                }
//                this.photo = bs.toByteArray();

//            
            } 
            }catch (Exception e) {
                e.printStackTrace();
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
        txtcin = new javax.swing.JTextField();
        txtnom = new javax.swing.JTextField();
        txtprenom = new javax.swing.JTextField();
        txtnum = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtprenompere = new javax.swing.JTextField();
        BtnImage = new javax.swing.JButton();
        RbtnHomme = new javax.swing.JRadioButton();
        RbtnFemme = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        txtpath = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TxtAdresseRue = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        TxtAdresseDes = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        TxtAdresseVille = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        TxtAdresseCode = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        TxtAdresseGouv = new javax.swing.JTextField();
        txtdate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        BtnAjoute = new javax.swing.JButton();
        BtnModif = new javax.swing.JButton();
        BtnSup = new javax.swing.JButton();
        BtnImp = new javax.swing.JButton();
        BtnEnregistrer = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Génerale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 54, 30, -1));

        jLabel3.setText("Nom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 92, -1, -1));

        jLabel4.setText("Prénom");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 133, -1, -1));

        jLabel5.setText("Numéro Telephone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel6.setText("Prénom Pére");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtcin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcinActionPerformed(evt);
            }
        });
        txtcin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcinKeyTyped(evt);
            }
        });
        jPanel1.add(txtcin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 140, -1));

        txtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomActionPerformed(evt);
            }
        });
        jPanel1.add(txtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 140, -1));
        jPanel1.add(txtprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, -1));

        txtnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumKeyTyped(evt);
            }
        });
        jPanel1.add(txtnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 140, -1));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 130, -1, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 112, -1, -1));
        jPanel1.add(txtprenompere, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 140, -1));

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
        jPanel1.add(BtnImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 170, 50));

        RbtnHomme.setText("Homme");
        RbtnHomme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnHommeActionPerformed(evt);
            }
        });
        jPanel1.add(RbtnHomme, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        RbtnFemme.setText("Femme");
        RbtnFemme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbtnFemmeActionPerformed(evt);
            }
        });
        jPanel1.add(RbtnFemme, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jLabel14.setText("Sexe");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel15.setText("Date Naissance");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file_image_1.png"))); // NOI18N
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 160, 130));

        txtpath.setEditable(false);
        jPanel1.add(txtpath, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 150, -1));

        jLabel19.setText("Numéro Rue");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        TxtAdresseRue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAdresseRueKeyTyped(evt);
            }
        });
        jPanel1.add(TxtAdresseRue, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 120, -1));

        jLabel20.setText("Désignation");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));
        jPanel1.add(TxtAdresseDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 120, -1));

        jLabel21.setText("Ville");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        jPanel1.add(TxtAdresseVille, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 120, -1));

        jLabel22.setText("Code Postal");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

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
        jPanel1.add(TxtAdresseCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 120, -1));

        jLabel23.setText("Gouvernorat");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));
        jPanel1.add(TxtAdresseGouv, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 120, -1));

        txtdate.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(txtdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 530, 500));

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

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Animateurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

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

        jPanel4.setBackground(new java.awt.Color(41, 75, 124));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gestion Animateur");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(474, 474, 474)
                .addComponent(jLabel16)
                .addContainerGap(398, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 50));

        setBounds(0, 0, 1050, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void BtnImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImpActionPerformed
        // TODO add your handling code here:
        MessageFormat header = new MessageFormat("Liste des Animateurs");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_BtnImpActionPerformed

    private void BtnImpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImpMouseExited
        // TODO add your handling code here:
        BtnImp.setContentAreaFilled(false);
        BtnImp.setForeground(Color.black);
    }//GEN-LAST:event_BtnImpMouseExited

    private void BtnImpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImpMouseEntered
        // TODO add your handling code here:
        BtnImp.setForeground(Color.white);
        BtnImp.setContentAreaFilled(true);
        BtnImp.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnImpMouseEntered

    private void BtnSupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupMouseExited
        // TODO add your handling code here:
        BtnSup.setContentAreaFilled(false);
        BtnSup.setForeground(Color.black);
    }//GEN-LAST:event_BtnSupMouseExited

    private void BtnSupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSupMouseEntered
        // TODO add your handling code here:
        BtnSup.setForeground(Color.white);
        BtnSup.setContentAreaFilled(true);
        BtnSup.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnSupMouseEntered

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

    private void BtnAjouteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAjouteMouseExited
        // TODO add your handling code here:
        BtnAjoute.setContentAreaFilled(false);
        BtnAjoute.setForeground(Color.black);

    }//GEN-LAST:event_BtnAjouteMouseExited

    private void BtnAjouteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAjouteMouseEntered
        // TODO add your handling code here:
        BtnAjoute.setForeground(Color.white);
        BtnAjoute.setContentAreaFilled(true);
        BtnAjoute.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnAjouteMouseEntered

    private void TxtAdresseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAdresseCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAdresseCodeActionPerformed

    private void RbtnFemmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnFemmeActionPerformed
        // TODO add your handling code here:
        sexee = "Feminin";
    }//GEN-LAST:event_RbtnFemmeActionPerformed

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

    private void BtnImageMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImageMouseExited
        // TODO add your handling code here:
        BtnImage.setContentAreaFilled(false);
        BtnImage.setForeground(Color.black);
    }//GEN-LAST:event_BtnImageMouseExited

    private void BtnImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnImageMouseEntered
        // TODO add your handling code here:
        BtnImage.setForeground(Color.white);
        BtnImage.setContentAreaFilled(true);
        BtnImage.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnImageMouseEntered

    private void txtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomActionPerformed

    private void txtcinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcinActionPerformed

    private void BtnEnregistrerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEnregistrerMouseEntered
        // TODO add your handling code here:
        BtnEnregistrer.setForeground(Color.white);
        BtnEnregistrer.setContentAreaFilled(true);
        BtnEnregistrer.setBackground(Color.decode("#FF6600"));
        
    }//GEN-LAST:event_BtnEnregistrerMouseEntered

    private void BtnEnregistrerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEnregistrerMouseExited
        // TODO add your handling code here:
        BtnEnregistrer.setContentAreaFilled(false);
        BtnEnregistrer.setForeground(Color.black);
    }//GEN-LAST:event_BtnEnregistrerMouseExited

    private void BtnAjouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouteActionPerformed
        // TODO add your handling code here:
        
        clear();
    }//GEN-LAST:event_BtnAjouteActionPerformed

    private void BtnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModifActionPerformed
        // TODO add your handling code here:
        /*
         String cl = (String) combo.getSelectedItem();
        
        String requete = "update animateur set CIN =?,nom =?,prenom=?,prenom_pere =?,date_naissance =?,sexe =?,numero =?,classe=?,numero_rue=?,designation=?,ville =?,code_postal =?,gouvernorat =?,image =? where  CIN ='" +txtcin.getText()+ "'";
        try {
            ps = conn.prepareStatement(requete);
             ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, txtprenompere.getText());
            ps.setString(5, ((JTextField) txtdate.getDateEditor().getUiComponent()).getText());
            ps.setString(6, sexee);
            ps.setString(7, txtnum.getText());
            ps.setString(8, cl);
            ps.setString(9, TxtAdresseRue.getText());
            ps.setString(10, TxtAdresseDes.getText());
            ps.setString(11, TxtAdresseVille.getText());
            ps.setString(12, TxtAdresseCode.getText());
            ps.setString(13, TxtAdresseGouv.getText());
            ps.setString(14, txtpath.getText());
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
        
        
        
        
        
        
        
          if (sexee.equals("Masculin")) {
                    RbtnHomme.setSelected(true);
                    RbtnFemme.setSelected(false);
                    
               } else if (sexee.equals("Feminin")) {
                   RbtnFemme.setSelected(true);
                   RbtnHomme.setSelected(false);
                   
               }
        
        
         String d = ((JTextField) txtdate.getDateEditor().getUiComponent()).getText();
      
                                // Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
                               
        
        
        
         //String cl = (String) combo.getSelectedItem();
         
         
         
        if(txtcin.getText().isEmpty() || txtnom.getText().isEmpty() ||txtprenom.getText().isEmpty() || txtprenompere.getText().isEmpty() ||txtdate.getDate().toString().isEmpty() || BtnGrp.isSelected(null) ||txtnum.getText().isEmpty() || TxtAdresseRue.getText().isEmpty() ||TxtAdresseDes.getText().isEmpty() ||TxtAdresseVille.getText().isEmpty() ||TxtAdresseCode.getText().isEmpty() ||TxtAdresseGouv.getText().isEmpty() ||txtpath.getText().isEmpty() )
        {
            
            JOptionPane.showMessageDialog(null, "Animateur non ajouté "
							+ " il y'a un chmap vide");
        }
        else if(txtnum.getText().toString().length()!=8 || TxtAdresseCode.getText().toString().length()!=4)
        {
            JOptionPane.showMessageDialog(null, "Animateur non ajouté \n"
							+ "il faut nombre de chifre numero=8 et nombre de chifre code postale =4");
        }
         
         else 
         {
             try {
			//instancier un animateur à ajouter dans la base d données:
            
				Animateur anim = new Animateur();
				anim.setId_cin(txtcin.getText());
				anim.setNom(txtnom.getText());
				anim.setPrenom(txtprenom.getText());
                                anim.setPrenomPere(txtprenompere.getText());
                                anim.setDateNaissance(d);
				anim.setSexe(sexee);
				anim.setNum_tel(txtnum.getText());
                                //anim.setClasse(cl);
                                anim.setNum_rue(TxtAdresseRue.getText());
				anim.setDesignation(TxtAdresseDes.getText());
				anim.setVille(TxtAdresseVille.getText());
                                anim.setCode_postal(TxtAdresseCode.getText());
                                anim.setGouvernorat(TxtAdresseGouv.getText());
                                anim.setImage(txtpath.getText());
                                
                             
				


                    //instancier le controleur:
                                
                                
				AnimateurController ac = new AnimateurController();
                                
                               
                                
                                    if(ac.updateAnimateur(anim))
				{
					JOptionPane.showMessageDialog(null, "Animateur modifié "
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
             remplirJTableanim();
         } catch (SQLException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         }
         }
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_BtnModifActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        try {
            // TODO add your handling code here:
            Deplace();
        } catch (ParseException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        selectedCIN = (String)Table.getValueAt(Table.getSelectedRow(),
						0);
        
    }//GEN-LAST:event_TableMouseClicked

    private void BtnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupActionPerformed
        // TODO add your handling code here:
        
        /*
        try {
            if(JOptionPane.showConfirmDialog(null,"attention vous devez suprimer un Animateur,est ce que tu es sur?","supprimer animateur", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
{
    String requete="delete from animateur where cin = '" + txtcin.getText() + "'";
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
        
        
        //on recupere le cin de l'animateur à supprimer:
				if(selectedCIN == null)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						AnimateurController ac = new AnimateurController();
						if(ac.deleteAnimateur(selectedCIN))
						{
							JOptionPane.showMessageDialog(null,
									"Animateur supprimé avec succès");
						}
					} catch (SQLException e1) {
                                            
						JOptionPane.showMessageDialog(null,
								"ما تنجمش تفسخ\n impossible de supprimer un animateur qui est appartient dan un classe \n il faut tout d'abord de lui remplacer\n"+e1.getMessage());
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null,
								e1.getMessage());
					}
				}
                                
        try {
            remplirJTableanim();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_BtnSupActionPerformed

    private void BtnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnregistrerActionPerformed
        // TODO add your handling code here:
        /*
        String cl = (String) combo.getSelectedItem();
        
        try {

            String requete = "insert into  animateur (CIN,nom,prenom,prenom_pere,date_naissance,sexe,numero,classe,numero_rue,designation,ville,code_postal,gouvernorat,image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtcin.getText());
            ps.setString(2, txtnom.getText());
            ps.setString(3, txtprenom.getText());
            ps.setString(4, txtprenompere.getText());
            ps.setString(5, ((JTextField) txtdate.getDateEditor().getUiComponent()).getText());
            ps.setString(6, sexee);
            ps.setString(7, txtnum.getText());  
            ps.setString(8, cl);  
            ps.setString(9, TxtAdresseRue.getText());
            ps.setString(10, TxtAdresseDes.getText());
            ps.setString(11, TxtAdresseVille.getText());
            ps.setString(12, TxtAdresseCode.getText());
            ps.setString(13, TxtAdresseGouv.getText());
            ps.setString(14, txtpath.getText());
            ps.execute();

            JOptionPane.showMessageDialog(null, "Enregistrement avec succès");

           

        } catch (Exception e) {
            System.out.println("--> SQLException : " + e);
            JOptionPane.showMessageDialog(null, "Tout est Obligatoire");
        } finally {

            try {
                ps.close();
                rs.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "deja inserre"+ex);
            }
        } 
Affichage();
        
*/
        
        
        
        
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //Date d = df.format(txtdate.getDate());
       // String cl = (String) combo.getSelectedItem();
        
        
        
        if(txtcin.getText().isEmpty() || txtnom.getText().isEmpty() ||txtprenom.getText().isEmpty() || txtprenompere.getText().isEmpty() ||txtdate.getDate().toString().isEmpty() || BtnGrp.isSelected(null) ||txtnum.getText().isEmpty() || TxtAdresseRue.getText().isEmpty() ||TxtAdresseDes.getText().isEmpty() ||TxtAdresseVille.getText().isEmpty() ||TxtAdresseCode.getText().isEmpty() ||TxtAdresseGouv.getText().isEmpty() ||txtpath.getText().isEmpty() )
        {
            
            JOptionPane.showMessageDialog(null, "Animateur non ajouté "
							+ " il y'a un chmap vide");
        }
        else if(txtnum.getText().toString().length()!=8 || TxtAdresseCode.getText().toString().length()!=4)
        {
            JOptionPane.showMessageDialog(null, "Animateur non ajouté \n"
							+ "il faut nombre de chifre numero=8 et nombre de chifre code postale =4");
        }
        else
        {
             try {
			//instancier un animateur à ajouter dans la base d données:
            
				Animateur newAnimateur = new Animateur();
				newAnimateur.setId_cin(txtcin.getText());
				newAnimateur.setNom(txtnom.getText());
				newAnimateur.setPrenom(txtprenom.getText());
                                newAnimateur.setPrenomPere(txtprenompere.getText());
                                
                             
      
      String d = ((JTextField) txtdate.getDateEditor().getUiComponent()).getText();
      
                                // Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(d);  
                             
                                
                                newAnimateur.setDateNaissance(d);
                                
                              //  newAnimateur.setDateNaissance(date1); 
                                
                                
                                
                                newAnimateur.setSexe(sexee);
                                newAnimateur.setNum_tel(txtnum.getText());
                                //newAnimateur.setClasse(cl);
                                newAnimateur.setNum_rue(TxtAdresseRue.getText());
                                newAnimateur.setDesignation(TxtAdresseDes.getText());
				newAnimateur.setVille(TxtAdresseVille.getText());
				newAnimateur.setCode_postal(TxtAdresseCode.getText());				
				newAnimateur.setGouvernorat(TxtAdresseGouv.getText());
				newAnimateur.setImage(txtpath.getText());
				


                    //instancier le controleur:
                                
                                
				AnimateurController ac = new AnimateurController();
				if(ac.addAnimateur(newAnimateur))
				{
					JOptionPane.showMessageDialog(null, "Animateur ajouté "
							+ " avec succès.");
				}
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Animateur non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Animateur non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
        try {
            remplirJTableanim();
            
            
            //String d=txtdate.getDate().toString();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        
       
        
        
        
    }//GEN-LAST:event_BtnEnregistrerActionPerformed

    private void RbtnHommeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbtnHommeActionPerformed
        // TODO add your handling code here:
       sexee = "Masculin";
    }//GEN-LAST:event_RbtnHommeActionPerformed

    private void txtcinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcinKeyTyped
        // TODO add your handling code here:
        
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtcinKeyTyped

    private void txtnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumKeyTyped
        // TODO add your handling code here:
        
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtnumKeyTyped

    private void TxtAdresseCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAdresseCodeKeyTyped
        // TODO add your handling code here:
        
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtAdresseCodeKeyTyped

    private void TxtAdresseRueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAdresseRueKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtAdresseRueKeyTyped


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
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField txtcin;
    private com.toedter.calendar.JDateChooser txtdate;
    private javax.swing.JTextField txtnom;
    private javax.swing.JTextField txtnum;
    private javax.swing.JTextField txtpath;
    private javax.swing.JTextField txtprenom;
    private javax.swing.JTextField txtprenompere;
    // End of variables declaration//GEN-END:variables
}
