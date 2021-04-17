/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stemsentertainmentcompany;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Future CEO
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
       this.setExtendedState(this.MAXIMIZED_BOTH);
       
    }
    
     public String strRole;
     
    public void mSetRoleRights()
    {
        if(strRole !=null)
        {
            switch(strRole)
            {
                case "ADMIN":
                    mnuLogoff.setVisible(true);
                    mnuExit.setVisible(true);
                    mnuPurchaseNewTicket.setVisible(true);
                    mnuMovieCatalog.setVisible(true);
                    break;
                case"SUPERVISOR":
                    mnuLogoff.setVisible(true);
                    mnuExit.setVisible(true);
                    mnuPurchaseNewTicket.setVisible(true);
                    mnuMovieCatalog.setVisible(true);
                    
                    break;
                case "STANDARD":
                    mnuLogoff.setVisible(true);
                    mnuExit.setVisible(true);
                    mnuPurchaseNewTicket.setVisible(true);
                    mnuMovieCatalog.setVisible(true);
                    mnuRegisterMovie.setVisible(false);
                    mnuBookedSessions.setVisible(false);
                    break;
                default:
                    break;
                    
            }
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpMain = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuLogoff = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuMovieCatalog = new javax.swing.JMenuItem();
        mnuPurchaseNewTicket = new javax.swing.JMenuItem();
        mnuRegisterMovie = new javax.swing.JMenuItem();
        mnuBookedSessions = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stems Movie Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(1);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        dpMain.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dpMainLayout = new javax.swing.GroupLayout(dpMain);
        dpMain.setLayout(dpMainLayout);
        dpMainLayout.setHorizontalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dpMainLayout.setVerticalGroup(
            dpMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuLogoff.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuLogoff.setText("Logoff");
        mnuLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoffActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLogoff);

        mnuExit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        mnuMovieCatalog.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuMovieCatalog.setText("Movie Catalog");
        mnuMovieCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovieCatalogActionPerformed(evt);
            }
        });
        jMenu2.add(mnuMovieCatalog);

        mnuPurchaseNewTicket.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuPurchaseNewTicket.setText("Purchase New Ticket");
        mnuPurchaseNewTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPurchaseNewTicketActionPerformed(evt);
            }
        });
        jMenu2.add(mnuPurchaseNewTicket);

        mnuRegisterMovie.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuRegisterMovie.setText("Register Movie");
        mnuRegisterMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegisterMovieActionPerformed(evt);
            }
        });
        jMenu2.add(mnuRegisterMovie);

        mnuBookedSessions.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mnuBookedSessions.setText("Booked Sessions");
        mnuBookedSessions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuBookedSessionsActionPerformed(evt);
            }
        });
        jMenu2.add(mnuBookedSessions);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpMain)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoffActionPerformed
        StemLogin frmSL = new StemLogin();
        frmSL.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuLogoffActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
           // Exit Program
         int YesOrNo = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit","Exit",JOptionPane.YES_NO_OPTION);
        
       if(YesOrNo == 0)
     {
        System.exit(0);
     }
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuRegisterMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegisterMovieActionPerformed
        RegisterNewMovie frmRNM = new RegisterNewMovie();
        dpMain.add(frmRNM);
        frmRNM.setVisible(true);
    }//GEN-LAST:event_mnuRegisterMovieActionPerformed

    private void mnuPurchaseNewTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPurchaseNewTicketActionPerformed
        PurchaseNewTicket frmPNT = new PurchaseNewTicket();
        dpMain.add(frmPNT);
        frmPNT.setVisible(true);
    }//GEN-LAST:event_mnuPurchaseNewTicketActionPerformed

    private void mnuMovieCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovieCatalogActionPerformed
       DisplayMovieCatalog frmDMC = new DisplayMovieCatalog();
      dpMain.add(frmDMC);
      frmDMC.setVisible(true);
    }//GEN-LAST:event_mnuMovieCatalogActionPerformed

    private void mnuBookedSessionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuBookedSessionsActionPerformed
         DisplayBookedSessions frmDBS = new   DisplayBookedSessions();
        dpMain.add(frmDBS);
        frmDBS.setVisible(true);
    }//GEN-LAST:event_mnuBookedSessionsActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpMain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem mnuBookedSessions;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuLogoff;
    private javax.swing.JMenuItem mnuMovieCatalog;
    private javax.swing.JMenuItem mnuPurchaseNewTicket;
    private javax.swing.JMenuItem mnuRegisterMovie;
    // End of variables declaration//GEN-END:variables
}