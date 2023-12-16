/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.MyConnection;
import javax.swing.*;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 *
 * @author nejib
 */
public class Acceuil extends javax.swing.JFrame {

    
    
    public static MyConnection myConnection = null;
    
    /**
     * Creates new form AcceuilGui
     */
    public Acceuil() throws ClassNotFoundException, SQLException {
        
        myConnection = new MyConnection();
        initComponents();
        datecourante();
        this.setIconImage(new ImageIcon(getClass().getResource("logo.png")).getImage());
        acc a=new acc();
        desk.add(a);
        a.show();
    }
    public void datecourante() {
        Thread clock = new Thread() {
            public void run() {
                for (;;) {
                    Calendar Cal = new GregorianCalendar();

                    int sconde = Cal.get(Calendar.SECOND);
                    int minute = Cal.get(Calendar.MINUTE);
                    int heure = Cal.get(Calendar.HOUR);
                    int AM_PM = Cal.get(Calendar.AM_PM);  
                    String pa;
                    if(AM_PM==1){
                        pa="PM";
                    }else{
                        pa="AM";
                    }
                    
                         
                    heur.setText( + heure + ":" + (minute) + ":" + sconde +" "+pa  );
                    
                 int mois = Cal.get(Calendar.MONTH);
                    int annee = Cal.get(Calendar.YEAR);
                    int jour = Cal.get(Calendar.DAY_OF_MONTH);

                    date.setText( + jour + "/" + (mois+1) + "/" + annee);              
                    
                    
                    
                }

            }

        };
        
clock.start();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logomax = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnAcc = new javax.swing.JButton();
        BtnEle = new javax.swing.JButton();
        BtnCo = new javax.swing.JButton();
        BtnCl = new javax.swing.JButton();
        heur = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        BtnAnim = new javax.swing.JButton();
        Btnco_anim_classe = new javax.swing.JButton();
        desk = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 720));
        setMinimumSize(new java.awt.Dimension(1366, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        logomax.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        logomax.setForeground(new java.awt.Color(41, 75, 124));
        logomax.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/poly.png"))); // NOI18N
        logomax.setText("PolyTech Sousse");
        getContentPane().add(logomax);
        logomax.setBounds(10, 0, 280, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gestiongarderie/images/Menu1.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1366, 50);

        jPanel1.setBackground(new java.awt.Color(41, 75, 124));

        BtnAcc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnAcc.setForeground(new java.awt.Color(255, 255, 255));
        BtnAcc.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        BtnAcc.setContentAreaFilled(false);
        BtnAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAcc.setLabel("Acceuil");
        BtnAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAccMouseExited(evt);
            }
        });
        BtnAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAccActionPerformed(evt);
            }
        });

        BtnEle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnEle.setForeground(new java.awt.Color(255, 255, 255));
        BtnEle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        BtnEle.setContentAreaFilled(false);
        BtnEle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEle.setLabel("Gestion Eleves");
        BtnEle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnEleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnEleMouseExited(evt);
            }
        });
        BtnEle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEleActionPerformed(evt);
            }
        });

        BtnCo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnCo.setForeground(new java.awt.Color(255, 255, 255));
        BtnCo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        BtnCo.setContentAreaFilled(false);
        BtnCo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCo.setLabel("Gestion Cours");
        BtnCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnCoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnCoMouseExited(evt);
            }
        });
        BtnCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCoActionPerformed(evt);
            }
        });

        BtnCl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnCl.setForeground(new java.awt.Color(255, 255, 255));
        BtnCl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        BtnCl.setContentAreaFilled(false);
        BtnCl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnCl.setLabel("Gestion Classes");
        BtnCl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnClMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnClMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnClMouseExited(evt);
            }
        });
        BtnCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClActionPerformed(evt);
            }
        });

        heur.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        heur.setForeground(new java.awt.Color(255, 102, 0));
        heur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heur.setText("heure");
        heur.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));

        date.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        date.setForeground(new java.awt.Color(255, 102, 0));
        date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        date.setText("date");
        date.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));

        BtnAnim.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BtnAnim.setForeground(new java.awt.Color(255, 255, 255));
        BtnAnim.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        BtnAnim.setContentAreaFilled(false);
        BtnAnim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAnim.setLabel("Gestion Animateurs");
        BtnAnim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAnimMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BtnAnimMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BtnAnimMouseExited(evt);
            }
        });
        BtnAnim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnimActionPerformed(evt);
            }
        });

        Btnco_anim_classe.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Btnco_anim_classe.setForeground(new java.awt.Color(255, 255, 255));
        Btnco_anim_classe.setText("Anim/Cours/Classe");
        Btnco_anim_classe.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 5, new java.awt.Color(255, 102, 0)));
        Btnco_anim_classe.setContentAreaFilled(false);
        Btnco_anim_classe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btnco_anim_classe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btnco_anim_classeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btnco_anim_classeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btnco_anim_classeMouseExited(evt);
            }
        });
        Btnco_anim_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btnco_anim_classeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAnim, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(heur, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(BtnCl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnCo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btnco_anim_classe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(heur, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(BtnAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnAnim, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnEle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btnco_anim_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 100, 260, 660);

        desk.setBackground(new java.awt.Color(240, 240, 240));
        desk.setOpaque(false);
        getContentPane().add(desk);
        desk.setBounds(290, 120, 1050, 580);

        jPanel2.setBackground(new java.awt.Color(41, 75, 124));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gardereie Kalaa Sghira");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 50, 1360, 50);

        setSize(new java.awt.Dimension(1377, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnimActionPerformed
        // TODO add your handling code here:
        this.desk.removeAll();
        this.desk.repaint();
       

        GestionAnimateur a = null;
        try {
            a = new GestionAnimateur();
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.desk.add(a);
        try {
            a.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        a.show();
    }//GEN-LAST:event_BtnAnimActionPerformed

    private void BtnEleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEleActionPerformed
        // TODO add your handling code here:
         this.desk.removeAll();
        this.desk.repaint();

        GestionEleve e = null;
        try {
            e = new GestionEleve();
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desk.add(e);
        try {
            e.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.show();
    }//GEN-LAST:event_BtnEleActionPerformed

    private void BtnAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAccMouseEntered
        // TODO add your handling code here:
        BtnAcc.setForeground(Color.white);
        BtnAcc.setContentAreaFilled(true);
        BtnAcc.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnAccMouseEntered

    private void BtnAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAccMouseExited
        // TODO add your handling code here:
        
        
                             BtnAcc.setContentAreaFilled(false);

        

            
    }//GEN-LAST:event_BtnAccMouseExited

    private void BtnAnimMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnimMouseEntered
        // TODO add your handling code here:
         BtnAnim.setForeground(Color.white);
        BtnAnim.setContentAreaFilled(true);
        BtnAnim.setBackground(Color.decode("#FF6600"));
        
    }//GEN-LAST:event_BtnAnimMouseEntered

    private void BtnAnimMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnimMouseExited
        // TODO add your handling code here:
       
                    BtnAnim.setContentAreaFilled(false);
        
    }//GEN-LAST:event_BtnAnimMouseExited

    private void BtnAnimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAnimMouseClicked
        // TODO add your handling code here:
        
      
        
        
    }//GEN-LAST:event_BtnAnimMouseClicked

    private void BtnAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAccActionPerformed
        // TODO add your handling code here:
         this.desk.removeAll();
        this.desk.repaint();

        acc ac = new acc();
        this.desk.add(ac);
        try {
            ac.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        ac.show();

    }//GEN-LAST:event_BtnAccActionPerformed

    private void BtnAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAccMouseClicked
        // TODO add your handling code here:
   

    }//GEN-LAST:event_BtnAccMouseClicked

    private void BtnEleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEleMouseEntered
        // TODO add your handling code here:
        BtnEle.setForeground(Color.white);
        BtnEle.setContentAreaFilled(true);
        BtnEle.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnEleMouseEntered

    private void BtnEleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEleMouseExited
        // TODO add your handling code here:
                            BtnEle.setContentAreaFilled(false);

    }//GEN-LAST:event_BtnEleMouseExited

    private void BtnCoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCoMouseEntered
        // TODO add your handling code here:
        BtnCo.setForeground(Color.white);
        BtnCo.setContentAreaFilled(true);
        BtnCo.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnCoMouseEntered

    private void BtnCoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCoMouseExited
        // TODO add your handling code here:
       BtnCo.setContentAreaFilled(false);

    }//GEN-LAST:event_BtnCoMouseExited

    private void BtnClMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClMouseEntered
        // TODO add your handling code here:
        BtnCl.setForeground(Color.white);
        BtnCl.setContentAreaFilled(true);
        BtnCl.setBackground(Color.decode("#FF6600"));
    }//GEN-LAST:event_BtnClMouseEntered

    private void BtnClMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClMouseExited
        // TODO add your handling code here:
        BtnCl.setContentAreaFilled(false);

    }//GEN-LAST:event_BtnClMouseExited

    private void BtnCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCoActionPerformed
        // TODO add your handling code here:
         this.desk.removeAll();
        this.desk.repaint();

        GestionCours co = null;
        try {
            co = new GestionCours();
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desk.add(co);
        try {
            co.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        co.show();
        
    }//GEN-LAST:event_BtnCoActionPerformed

    private void BtnClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClActionPerformed
        // TODO add your handling code here:
        this.desk.removeAll();
        this.desk.repaint();

        GestionClasse cl = null;
        try {
            cl = new GestionClasse();
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.desk.add(cl);
        try {
            cl.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        cl.show();
    }//GEN-LAST:event_BtnClActionPerformed

    private void BtnClMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnClMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnClMouseClicked

    private void BtnEleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEleMouseClicked

    private void BtnCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCoMouseClicked

    private void Btnco_anim_classeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btnco_anim_classeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Btnco_anim_classeMouseClicked

    private void Btnco_anim_classeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btnco_anim_classeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Btnco_anim_classeMouseEntered

    private void Btnco_anim_classeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btnco_anim_classeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Btnco_anim_classeMouseExited

    private void Btnco_anim_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btnco_anim_classeActionPerformed
        // TODO add your handling code here:
        
        this.desk.removeAll();
        this.desk.repaint();
       

        Anim_Cours_Classe acocl = null;
        try {
            acocl = new Anim_Cours_Classe();
        } catch (SQLException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.desk.add(acocl);
        try {
            acocl.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
        }
        acocl.show();
        
        
    }//GEN-LAST:event_Btnco_anim_classeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Acceuil().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Acceuil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAcc;
    private javax.swing.JButton BtnAnim;
    private javax.swing.JButton BtnCl;
    private javax.swing.JButton BtnCo;
    private javax.swing.JButton BtnEle;
    private javax.swing.JButton Btnco_anim_classe;
    private javax.swing.JLabel date;
    public javax.swing.JDesktopPane desk;
    private javax.swing.JLabel heur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logomax;
    // End of variables declaration//GEN-END:variables
}
