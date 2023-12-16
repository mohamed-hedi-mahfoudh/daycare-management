/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;





import Controller.AnimateurController;
import Controller.ClasseController;
import Controller.CoursController;
import Model.Animateur;
import Model.Classe;
import Model.Cours;
import static View.GestionAnimateur.test;
import com.gestiongarderie.frame.ConexionBD;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
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
public class GestionCours extends javax.swing.JInternalFrame {
    
    
     private String selectedcode=null; 
     String selectedcin=null;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    static String test;
    private DefaultTableModel model = new DefaultTableModel();
   
    
    /**
     * Creates new form GestionCours
     */
    public GestionCours() throws SQLException, ClassNotFoundException {
        initComponents();
        RemoveTitleBar();
        //conn = ConexionBD.Conexion();
       // Affichage();
       // AffichageAnimateur();
        //updateComboanim();
        //updateComboclasse();
        
      
        
        remplirJTable();
        remplirJTableanim();
       //c.updateCombo();
        setCombo();
      
        
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
            String requete = "select * from cours";
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
    
    
    
    
    private void remplirJTableclasse() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("Nom_Classe");		
	           CoursController C = new CoursController();
	        ArrayList<Classe> liste = C.listerClasse(selectedcode);
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
		//model.addColumn("Date Naissance");
		//model.addColumn("sexe");
		model.addColumn("Num_tel");
                //model.addColumn("classe");
                //model.addColumn("num_rue");
               // model.addColumn("designation");
                //model.addColumn("ville");
                //model.addColumn("code_postal");
                //model.addColumn("gouvernorat");
		//model.addColumn("Image");
	        CoursController C = new CoursController();
	        ArrayList<Animateur> liste = C.listeranim(selectedcode);
	        for (int i=0;i<liste.size();i++)
	        {
	        Animateur currentAnimateur = liste.get(i);
	        model.addRow(new Object[]{currentAnimateur.getId_cin(),
	        currentAnimateur.getNom(), 
                currentAnimateur.getPrenom(),
	        currentAnimateur.getPrenomPere(),
	        //currentAnimateur.getDateNaissance().toString(),
	        //currentAnimateur.getSexe(),
                currentAnimateur.getNum_tel(),
	        //currentAnimateur.getClasse(),
                //currentAnimateur.getNum_rue(),
                //currentAnimateur.getDesignation(),
                //currentAnimateur.getVille(),
                //currentAnimateur.getCode_postal(),
                //currentAnimateur.getGouvernorat(),
	        //currentAnimateur.getImage()
                });
	        }
	        TableAnimateur.setModel(model);
	}
    
   
    
    
    
    
    public void Deplace() {
       
            
           

            int row = Table.getSelectedRow();
            String code = (Table.getModel().getValueAt(row, 0).toString());
            String des = (Table.getModel().getValueAt(row, 1).toString());
            //String animres = (Table.getModel().getValueAt(row, 2).toString());
           // String cls = (Table.getModel().getValueAt(row, 3).toString());
            String prix = (Table.getModel().getValueAt(row, 2).toString());

            
                
                txtcode.setText(code);                
                txtdes.setText(des);
               // comboanim.setSelectedItem(animres);
                //comboclasse.setSelectedItem(cls);
                txtprix.setText(prix);
                
                
                //comboanim.setSelectedItem(rs.getString("animateur_responsable"));
               // comboclasse.setSelectedItem(rs.getString("classe"));
                
               // String t3 = rs.getString("animateur_responsable");
                //txtprenom.setText(t3);
               

                

            
    
    
    }
    
    
    public void clear() {
        try {

            txtcode.setText("");
            txtdes.setText("");
            //txtprenom.setText("");
            //comboanim.setSelectedItem(null);
            //comboclasse.setSelectedItem(null);
            txtprix.setText("");
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /*
    private void remplirJTableanim() throws SQLException, ClassNotFoundException
	{ 
           // JCheckBox cb=new JCheckBox();
            
		model = new DefaultTableModel();
               // model.addColumn("seleciton");
		model.addColumn("CIN");
		model.addColumn("Nom");
		model.addColumn("Prenom");
		model.addColumn("Prenom_pere");
		model.addColumn("Num_tel");
            
	        AnimateurController C = new AnimateurController();
	        ArrayList<Animateur> liste = C.listerAnimateur();
	        for (int i=0;i<liste.size();i++)
	        {
	        Animateur currentAnimateur = liste.get(i);
	        model.addRow(new Object[]{currentAnimateur.getId_cin(),
	        currentAnimateur.getNom(), currentAnimateur.getPrenom(),
	        currentAnimateur.getPrenomPere(),	            
                currentAnimateur.getNum_tel(),
	        
           });
	        }
	        TableAnimateur.setModel(model);
	}
    
    */
    
    public void remplir_table(){
model = new DefaultTableModel();
model.addColumn("Abr\u00e9viation");
model.addColumn("Nom complet");
model.addColumn("Choix");
model.addColumn("Taux d'humidit\u00e9");
model.addColumn("Taux d'\u00e9bullition");

Object[] t1 ={"jkjhklhk","khklhh",Boolean.FALSE,"pkoj","poioi"};
JCheckBox check = new JCheckBox();



model.addRow(t1);
TableAnimateur = new JTable(model);
jScrollPane2.setViewportView(TableAnimateur);
}
    
    
    
    
    /*
    public void updateComboanim()
    {
         String requet = " select * from  animateur ";
         try
         {
             ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            while(rs.next())
            {
                comboanim.addItem(rs.getString("CIN"));
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }

    }
    
    public void updateComboclasse()
    {
         String requet = " select * from  classe ";
         try
         {
             ps = conn.prepareStatement(requet);
            rs = ps.executeQuery();
            while(rs.next())
            {
                comboclasse.addItem(rs.getString("nom_classe"));
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         }

    }
    */
    
    private void remplirJTable() throws SQLException, ClassNotFoundException
	{ 
		model = new DefaultTableModel();
		model.addColumn("Code");
		model.addColumn("Designation");
		//model.addColumn("Animateur Responsable");
		//model.addColumn("Classe");
                model.addColumn("Prix");
		
	         CoursController cc = new CoursController();
	        ArrayList<Cours> liste = cc.listerCours();
	        for (int i=0;i<liste.size();i++)
	        {
	        Cours currentCours = liste.get(i);
	        model.addRow(new Object[]{currentCours.getCode(),
	        currentCours.getDesignation(),
	         currentCours.getPrix()
                });
	        }
	        Table.setModel(model);
	}
    
    
    public void setCombo() throws ClassNotFoundException, SQLException
    {
         ClasseController cc = new ClasseController();
         
ArrayList<Classe> listecl = null;
        try {
            listecl = cc.listerClasse();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
	        for (int i=0;i<listecl.size();i++)
	        {
	        Classe currentClasse = listecl.get(i);
	        //comboclasse.addItem(currentClasse.getNomClasse());
         
                }
                
        
              
     AnimateurController ac = new AnimateurController();
         
ArrayList<Animateur> listean = null;
        try {
            listean = ac.listerAnimateur();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
	        for (int i=0;i<listean.size();i++)
	        {
	        Animateur currentanim = listean.get(i);
	       // comboanim.addItem(currentanim.getId_cin());
         
                }           
                
        
    }
    
    
    /*
    public void AffichageAnimateur() {
        try {
            String requete = "select CIN,nom,prenom,prenom_pere from animateur";
            ps = conn.prepareStatement(requete);
            rs = ps.executeQuery();
            TableAnimateur.setModel(DbUtils.resultSetToTableModel(rs));
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
        TableAnimateur = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableClasse = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BtnAjoute = new javax.swing.JButton();
        BtnModif = new javax.swing.JButton();
        BtnSup = new javax.swing.JButton();
        BtnImp = new javax.swing.JButton();
        BtnEnregistrer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtdes = new javax.swing.JTextField();
        jlapeblprix = new javax.swing.JLabel();
        txtprix = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Génerale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 130, -1, -1));
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 112, -1, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Des Animateurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

        TableAnimateur.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TableAnimateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "hhhhhh4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableAnimateur.setAutoscrolls(false);
        TableAnimateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAnimateurMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableAnimateur);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 450, 190));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Classes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N

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
        jScrollPane4.setViewportView(TableClasse);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 530, 500));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste Des Cours", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(41, 75, 124))); // NOI18N
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        Table.setAutoscrolls(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 450, 170));

        jPanel4.setBackground(new java.awt.Color(41, 75, 124));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gestion Cours");

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

        jLabel1.setText("Code");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });
        getContentPane().add(txtcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 140, -1));

        jLabel3.setText("Désignation");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        txtdes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdesActionPerformed(evt);
            }
        });
        getContentPane().add(txtdes, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 140, -1));

        jlapeblprix.setText("Prix");
        getContentPane().add(jlapeblprix, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        txtprix.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprixKeyTyped(evt);
            }
        });
        getContentPane().add(txtprix, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 140, -1));

        setBounds(0, 0, 1050, 621);
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodeActionPerformed

    private void txtdesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdesActionPerformed

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

    private void BtnModifMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModifMouseEntered
        // TODO add your handling code here:
        BtnModif.setForeground(Color.white);
        BtnModif.setContentAreaFilled(true);
        BtnModif.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnModifMouseEntered

    private void BtnModifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnModifMouseExited
        // TODO add your handling code here:
        BtnModif.setContentAreaFilled(false);
        BtnModif.setForeground(Color.black);
    }//GEN-LAST:event_BtnModifMouseExited

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
        MessageFormat header = new MessageFormat("Liste des Cours");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
        try {
            Table.print(JTable.PrintMode.NORMAL, header, footer);

        } catch (java.awt.print.PrinterException e) {
            System.err.format("Erreur d'impression ", e.getMessage());
        }
    }//GEN-LAST:event_BtnImpActionPerformed

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
        String requete = "update cours set code =?,designation =?,animateur_responsable=? where  code ='" +txtcode.getText()+ "'";
        try {
            ps = conn.prepareStatement(requete);
             ps.setString(1, txtcode.getText());
            ps.setString(2, txtdes.getText());
            ps.setString(3, (String) comboanim.getSelectedItem());
           
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
        
        
        
      //  String as = (String) comboanim.getSelectedItem();
       //  String cl = (String) comboclasse.getSelectedItem();
        
        
         if(txtcode.getText().isEmpty() || txtdes.getText().isEmpty() ||txtprix.getText().isEmpty()  )
        {
            
            JOptionPane.showMessageDialog(null, "Cours non ajouté "
							+ " il y'a un chmap vide");
        }
        
         else
        {
        
        
        try {
			//instancier un animateur à ajouter dans la base d données:
            
				Cours cour = new Cours();
				cour.setCode(txtcode.getText());
				cour.setDesignation(txtdes.getText());
				//cour.setId_animateur(as);
                                //cour.setNom_classe(cl);
                                cour.setPrix(Integer.parseInt(txtprix.getText()));
                                
                             
				String pr =txtprix.getText().toString();
                                

                    //instancier le controleur:
                                
                                
				CoursController courcontr = new CoursController();
                                
                                if(txtcode.getText().equals("") || txtdes.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null, "cours non modifié");
                                }
                                else
                                {
                                    if(courcontr.updateCours(cour))
				{
					JOptionPane.showMessageDialog(null, "Cours modifié "
							+ " avec succès.");
				}
                                }
				
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Cours non modifié"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Cours non modifié"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
         try {
             remplirJTable();
         } catch (SQLException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        
        
        
        
        }
        
    }//GEN-LAST:event_BtnModifActionPerformed

    private void BtnSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSupActionPerformed
       
        // TODO add your handling code here:
        /*
        try {
            if(JOptionPane.showConfirmDialog(null,"attention vous devez suprimer un Cours,est ce que tu es sur?","supprimer Cours", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION)
{
    String requete="delete from cours where code = '" + txtcode.getText() + "'";
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
        
        if(selectedcode == null)
				{
					JOptionPane.showMessageDialog(null,
							"Veuillez selectionner une ligne !!");
				}
				else
				{
					
					try {
						CoursController cc = new CoursController();
						if(cc.deleteCours(selectedcode))
						{
							JOptionPane.showMessageDialog(null,
									"Cours supprimé avec succès");
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
            remplirJTable();
        } catch (SQLException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionAnimateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_BtnSupActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        
        Deplace();
        
        selectedcode= (String)Table.getValueAt(Table.getSelectedRow(),
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
            remplirJTableclasse();
        } catch (SQLException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestionClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
        
       
    }//GEN-LAST:event_TableMouseClicked

    private void BtnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnregistrerActionPerformed
        // TODO add your handling code here:
        
        
        /*
        try {

            String requete = "insert into  cours (code,designation ,animateur_responsable,classe) values (?,?,?,?)";
            ps = conn.prepareStatement(requete);
            ps.setString(1, txtcode.getText());
            ps.setString(2, txtdes.getText());
            ps.setString(3, (String) comboanim.getSelectedItem());
            ps.setString(4, (String) comboclasse.getSelectedItem());
           
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
        
       
         
        // String as = (String) comboanim.getSelectedItem();
        // String cl = (String) comboclasse.getSelectedItem();
        
         if(txtcode.getText().isEmpty() || txtdes.getText().isEmpty() ||txtprix.getText().isEmpty()  )
        {
            
            JOptionPane.showMessageDialog(null, "Cours non ajouté "
							+ " il y'a un chmap vide");
        }
        
         else
        {
        
        
        
        try {
			//instancier un animateur à ajouter dans la base d données:
            
				Cours cour = new Cours();
				cour.setCode(txtcode.getText());
				cour.setDesignation(txtdes.getText());
				//cour.setId_animateur(as);
                               // cour.setNom_classe(cl);
                                cour.setPrix(Integer.parseInt(txtprix.getText()));
                                
                             
				


                    //instancier le controleur:
                                
                                
				CoursController courcontr = new CoursController();
                                
                                if(txtcode.getText().equals("") || txtdes.getText().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null, "cours nonajouté car champ vide");
                                }
                                else
                                {
                                    if(courcontr.addCours(cour))
				{
					JOptionPane.showMessageDialog(null, "Cours ajouté "
							+ " avec succès.");
				}
                                }
				
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Cours non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Cours non ajouté"
							+ "  suite à cette erreur : \n"+ e1.getMessage());					
				}
        
         try {
             remplirJTable();
         } catch (SQLException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(GestionCours.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        }
    }//GEN-LAST:event_BtnEnregistrerActionPerformed

    private void TableAnimateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAnimateurMouseClicked
        // TODO add your handling code here:
       // Deplace();
        
         selectedcin= (String)TableAnimateur.getValueAt(TableAnimateur.getSelectedRow(),0);
         
        

System.out.println(TableAnimateur.getSelectedRows());
         
         


        
    }//GEN-LAST:event_TableAnimateurMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void txtprixKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprixKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(!Character.isDigit(c))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtprixKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAjoute;
    private javax.swing.JButton BtnEnregistrer;
    private javax.swing.JButton BtnImp;
    private javax.swing.JButton BtnModif;
    private javax.swing.JButton BtnSup;
    private javax.swing.JTable Table;
    private javax.swing.JTable TableAnimateur;
    private javax.swing.JTable TableClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlapeblprix;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtdes;
    private javax.swing.JTextField txtprix;
    // End of variables declaration//GEN-END:variables
}
