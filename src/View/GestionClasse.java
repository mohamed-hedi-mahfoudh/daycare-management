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
import Model.Classe;
import Model.Cours;
import Model.Eleves;
import com.gestiongarderie.frame.ConexionBD;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author nejib
 */
public class GestionClasse extends javax.swing.JInternalFrame {
    
    private String selectednomclasse=null; 
    private DefaultTableModel model = new DefaultTableModel();
    
    //Connection conn = null;
    //ResultSet rs = null;
    //PreparedStatement ps = null;
    static String test;

    /**
     * Creates new form GestionClasse
     */
    public GestionClasse() throws SQLException, ClassNotFoundException {
        initComponents();
        RemoveTitleBar();
        
        remplirJTableclasse();
        //remplirJTableanim();
       // remplirJTablecours();
        
        
       //conn = ConexionBD.Conexion();
       // Affichage();
        
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
            String requete = "SELECT nom_classe, COUNT(*) as nombre_des_eleves FROM classe , eleve WHERE classe.nom_classe=eleve.classe GROUP BY nom_classe";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            TableClasse.setModel(DbUtils.resultSetToTableModel(rs));
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
     public void Affichageanim() {
         
         int row = TableClasse.getSelectedRow();
            this.test = (TableClasse.getModel().getValueAt(row, 0).toString());
        try {
            String requete = "select * from animateur,classe where animateur.classe=classe.nom_classe and nom_classe='"+test+"'"  ;
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            tableanim.setModel(DbUtils.resultSetToTableModel(rs));
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
     
     
      public void Affichageelev() {
         
         int row = TableClasse.getSelectedRow();
            this.test = (TableClasse.getModel().getValueAt(row, 0).toString());
        try {
            String requete = "select * from eleve,classe where eleve.classe=classe.nom_classe and nom_classe='"+test+"'"  ;
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            tableelev.setModel(DbUtils.resultSetToTableModel(rs));
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
      
      
      public void Affichagecours() {
         
         int row = TableClasse.getSelectedRow();
            this.test = (TableClasse.getModel().getValueAt(row, 0).toString());
        try {
            String requete = "select * from cours,classe where cours.classe=classe.nom_classe and nom_classe='"+test+"'"  ;
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            tablecours.setModel(DbUtils.resultSetToTableModel(rs));
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
    
    
    
    private void remplirJTableclasse() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("Nom_Classe");		
	           ClasseController C = new ClasseController();
	        ArrayList<Classe> liste = C.listerClasse();
	        for (int i=0;i<liste.size();i++)
	        {
	        Classe currentClasse = liste.get(i);
	        model.addRow(new Object[]{currentClasse.getNomClasse(),
	        });
	        }
	        TableClasse.setModel(model);
	}
    
    
    
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
	        ClasseController C = new ClasseController();
	        ArrayList<Animateur> liste = C.listeranim(selectednomclasse);
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
	        tableanim.setModel(model);
	}
    
    private void remplirJTablecours() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("Code");	
                model.addColumn("Designation");	
                //model.addColumn("Animateur Responsable");	
                // model.addColumn("Classe");
                model.addColumn("Prix");
	           ClasseController C = new ClasseController();
	        ArrayList<Cours> liste = C.listercours(selectednomclasse);
	        for (int i=0;i<liste.size();i++)
	        {
	        Cours currentCours = liste.get(i);
	        model.addRow(new Object[]{currentCours.getCode(),
                currentCours.getDesignation(),
	        //currentCours.getId_animateur(),
                //currentCours.getNom_classe(),
                currentCours.getPrix()
                        
	        });
	        }
	        tablecours.setModel(model);
	}
    
    
    
    private void remplirJTableeleve() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nom");
		model.addColumn("Prenom");
		model.addColumn("Prenom_pere");
		model.addColumn("Date Naissance");
		model.addColumn("sexe");
                model.addColumn("CIN_Pere");
                model.addColumn("Num_Pere");
                model.addColumn("Prenom_Grand_Pere_Pere");
                model.addColumn("Prenom_Grand_Pere_Mere");
                model.addColumn("classe");
                model.addColumn("num_rue");
                model.addColumn("designation");
                model.addColumn("ville");
                model.addColumn("code_postal");
                model.addColumn("gouvernorat");
		model.addColumn("Image");
	         ClasseController C = new ClasseController();
	        ArrayList<Eleves> liste = C.listereleve(selectednomclasse);
	       
	        for (int i=0;i<liste.size();i++)
	        {
	        Eleves currentEleve = liste.get(i);
	        model.addRow(new Object[]{currentEleve.getId_cin(),
	        currentEleve.getNom(), currentEleve.getPrenom(),
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
	        tableelev.setModel(model);
	}
    
    
    
    /*
    private void remplirJTableclasse() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("Nom_Classe");		
	           ClasseController C = new ClasseController();
	        ArrayList<Classe> liste = C.listerClasse();
	        for (int i=0;i<liste.size();i++)
	        {
	        Classe currentClasse = liste.get(i);
	        model.addRow(new Object[]{currentClasse.getNomClasse(),
	        });
	        }
	        TableClasse.setModel(model);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablecours = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableanim = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableelev = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtnomclasse = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableClasse = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnAjoute = new javax.swing.JButton();
        BtnSup = new javax.swing.JButton();
        BtnImp = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Génerale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 130, -1, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 112, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Cours", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        tablecours.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablecours.setModel(new javax.swing.table.DefaultTableModel(
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
        tablecours.setAutoscrolls(false);
        jScrollPane2.setViewportView(tablecours);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 450, 130));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Animateurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        tableanim.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableanim.setModel(new javax.swing.table.DefaultTableModel(
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
        tableanim.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableanim.setAutoscrolls(false);
        jScrollPane3.setViewportView(tableanim);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 450, 130));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Eleves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        tableelev.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableelev.setModel(new javax.swing.table.DefaultTableModel(
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
        tableelev.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableelev.setAutoscrolls(false);
        jScrollPane4.setViewportView(tableelev);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 450, 130));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ajouter  Nouvelle Classe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        txtnomclasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomclasseActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom Du Classe");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnomclasse, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnomclasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 280, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 530, 510));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Classes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        TableClasse.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TableClasse.setModel(new javax.swing.table.DefaultTableModel(
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
        TableClasse.setAutoscrolls(false);
        TableClasse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClasseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableClasse);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 450, 210));

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
        jLabel16.setText("Gestion Classes");

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Action", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        BtnAjoute.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnAjoute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/file.png"))); // NOI18N
        BtnAjoute.setText("Ajouter");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(BtnAjoute, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(BtnSup, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(BtnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAjoute, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BtnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 450, 150));

        setBounds(0, 0, 1050, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomclasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomclasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomclasseActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

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
        MessageFormat header = new MessageFormat("Liste des Classes");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            TableClasse.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_BtnImpActionPerformed

    private void TableClasseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClasseMouseClicked
        // TODO add your handling code here:
        
        selectednomclasse=(String)TableClasse.getValueAt(TableClasse.getSelectedRow(),
						0);
        try {
            // Affichageanim();
            // Affichageelev();
            //Affichagecours();
            remplirJTableanim();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            remplirJTablecours();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            remplirJTableeleve();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_TableClasseMouseClicked

    private void BtnAjouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAjouteActionPerformed
        // TODO add your handling code here:
        
        try {
			//instancier un animateur à ajouter dans la base d données:
            
				Classe cl = new Classe();
				cl.setNomClasse(txtnomclasse.getText());
				
				


                    //instancier le controleur:
                                
                                
				ClasseController cc = new ClasseController();
                                if(txtnomclasse.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null, "Classe nonajouté champ vide");
                                }
                                else
                                {
                                    if(cc.addClasse(cl))
				{
					JOptionPane.showMessageDialog(null, "Classe ajouté "
							+ " avec succès.");
				}
                                }
				
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Classe non ajouté car il déja existe"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
        
        try {
            remplirJTableclasse();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_BtnAjouteActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void BtnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupActionPerformed
        // TODO add your handling code here:
        
        if(selectednomclasse == null)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						ClasseController ac = new ClasseController();
						if(ac.deleteClasse(selectednomclasse))
						{
							JOptionPane.showMessageDialog(null,
									"Classe supprimé avec succès");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null,
								"impoossible de supprimer un classe qui déja conteint des cours ou eleves ou animateurs");
					}
				}
                                
        try {
            remplirJTableclasse();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_BtnSupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjoute;
    private javax.swing.JButton BtnImp;
    private javax.swing.JButton BtnSup;
    private javax.swing.JTable TableClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tableanim;
    private javax.swing.JTable tablecours;
    private javax.swing.JTable tableelev;
    private javax.swing.JTextField txtnomclasse;
    // End of variables declaration//GEN-END:variables
}
