/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stemsentertainmentcompany;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Lwandile
 */
public class RegisterNewMovie extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegisterNewMovie
     */
    public RegisterNewMovie() {
        initComponents();
    }
    
    Boolean boolRecordExists = false;
    Boolean boolEdit = false;
    Boolean boolCreate = false;
    String strMovieName;
    String strGenre;
    int intMovieID;
       
    private void mClearVariables()
    {
    strMovieName="";
    strGenre="";
    }
    private void mGetValuesFromGUI()
    {
        strMovieName = txtMoviename.getText();
        strGenre = txtGenre.getText();
        
    }
    
    private void mSetValuesToUpperCase()
    {
        strMovieName = strMovieName.toUpperCase();
        strGenre = strGenre.toUpperCase();
      
    }

    private void mSetValuesInGUI()
    {
       txtMoviename.setText(strMovieName);
       txtGenre.setText(strGenre);
    }
    
    private void mClearTextFields()
    {
        txtMoviename.setText("");
        txtGenre.setText("");
    }
        private void mcheckIfItemExistinTable()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/stems";
        String strDBUser = "root";
        String strDBPassword= "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        try 
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery = "Select * from movie_catalog where Movie_name='" +strMovieName+ "'and Genre='"+strGenre+"'";
           stStatement.execute(strQuery);
           rs = stStatement.getResultSet();
           boolRecordExists = rs.next();           
                   }catch (Exception e){
                       JOptionPane.showMessageDialog(null, e);
                   }finally {
            try{
            stStatement.close();
            }catch (Exception e){
                       JOptionPane.showMessageDialog(null, "Connection String not Closed"+ " "+ e);
        }
        }
    }
      private void mCreateMovie()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL =  "jdbc:mysql://localhost:3306/stems";
        String User = "root";
        String Password= "password";
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
           Statement myStatement=conMySQLConnectionString.createStatement();
           String sqlinsert = "insert into Movie_catalog(Movie_name,Genre)"+"values('"+strMovieName+"','"+strGenre+"')";
           myStatement.execute(sqlinsert);
           myStatement.close();
           JOptionPane.showMessageDialog(null, "Complete");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      
      private void mLoadMovieName()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/stems";
        String strDBUser = "root";
        String strDBPassword= "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery="Select Movie_Name FROM movie_catalog";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
               cboMoviename.addItem(rs.getString(1));
               
           }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection string not closed"+" "+e);
            }
        }
    }
         private void mUpdateMovie()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/stems";
        String strDBUser = "root";
        String strDBPassword= "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try{
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery = "Update Movie_catalog SET Movie_Name='"+strMovieName+"',Genre='"+strGenre+"'WHERE ID="+intMovieID;
           stStatement.execute(strQuery);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection string not closed!"+" "+ e);
            }
        }
    } 
      
       private void mClearComboBox()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboMoviename.setModel(model);
    }
    private void mDeleteMovie()
    {
       String strDBConnectionString = "jdbc:mysql://localhost:3306/stems";
        String strDBUser = "root";
        String strDBPassword= "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try{
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword); 
           
           String strQuery= "Delete from Movie_catalog where Movie_Name='"+strMovieName+"'and Genre='"+strGenre+"'and ID="+intMovieID;
           stStatement=conMySQLConnectionString.prepareStatement(strQuery);
           stStatement.execute(strQuery);
        }
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, e);
        }
    finally{
            try{
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection string not closed!"+" " +e);
            }
        }
    }
      private void mReadMovieDetails()
      {
         String strDBConnectionString = "jdbc:mysql://localhost:3306/stems";
        String strDBUser = "root";
        String strDBPassword= "password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery="Select ID,Movie_Name,Genre from movie_catalog where movie_Name='"+ cboMoviename.getSelectedItem().toString()+"'";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
               intMovieID = rs.getInt(1);
               strMovieName= rs.getString(2);
               strGenre = rs.getString(3);
               
               
           }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Connection string not closed"+" "+e);
            }  
      }
      }
      private void mLoadGUIControls()
      {
          txtMoviename.setEnabled(false);
          txtGenre.setEnabled(false);
          cboMoviename.setEnabled(true);
          btnCreate.setEnabled(true);
          btnLoad.setEnabled(true);
          btnEdit.setEnabled(true);
          btnSave.setEnabled(false);
          btnDelete.setEnabled(false);
      }
      private void mEditGUIControls()
      {
          txtMoviename.setEnabled(true);
          txtGenre.setEnabled(true);
          cboMoviename.setEnabled(false);
          btnCreate.setEnabled(false);
          btnLoad.setEnabled(false);
          btnEdit.setEnabled(false);
          btnSave.setEnabled(true);
          btnDelete.setEnabled(true);
      }
      private void mSaveGUIControls()
      { 
          txtMoviename.setEnabled(false);
          txtGenre.setEnabled(false);
         cboMoviename.setEnabled(true);
          btnCreate.setEnabled(true);
          btnLoad.setEnabled(true);
          btnEdit.setEnabled(true);
          btnSave.setEnabled(false);
          btnDelete.setEnabled(false);
      }
      private void mCreateGUIControls()
      {
         txtMoviename.setEnabled(true);
           txtGenre.setEnabled(true);
          cboMoviename.setEnabled(false);
          btnCreate.setEnabled(false);
          btnLoad.setEnabled(false);
          btnEdit.setEnabled(false);
          btnSave.setEnabled(true);
          btnDelete.setEnabled(true);
      }
      private void mDeleteControls()
      {   
          txtMoviename.setEnabled(false);
          txtGenre.setEnabled(false);
         cboMoviename.setEnabled(true);
          btnCreate.setEnabled(true);
          btnLoad.setEnabled(true);
          btnEdit.setEnabled(true);
          btnSave.setEnabled(false);
          btnDelete.setEnabled(false);
      }
           
         
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cboMoviename = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtMoviename = new javax.swing.JTextField();
        txtGenre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Register New Movie");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        cboMoviename.setBackground(new java.awt.Color(51, 51, 51));
        cboMoviename.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        cboMoviename.setForeground(new java.awt.Color(255, 255, 0));
        cboMoviename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMovienameActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        jLabel1.setText("Movie Name:");

        txtMoviename.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N

        txtGenre.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        jLabel2.setText("Genre:");

        btnCreate.setBackground(new java.awt.Color(51, 51, 51));
        btnCreate.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 0));
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnLoad.setBackground(new java.awt.Color(51, 51, 51));
        btnLoad.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        btnLoad.setForeground(new java.awt.Color(255, 255, 0));
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(51, 51, 51));
        btnEdit.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 0));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(51, 51, 51));
        btnSave.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 51, 51));
        btnDelete.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Goudy Old Style", 2, 13)); // NOI18N
        jLabel3.setText("Select/Load a movie:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMoviename, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMoviename)
                                .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cboMoviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMoviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnCreate)
                .addGap(47, 47, 47)
                .addComponent(btnLoad)
                .addGap(46, 46, 46)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(49, 49, 49)
                .addComponent(btnDelete)
                .addGap(66, 66, 66)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/AmericanSniper.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/Taken3.jpg"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/exMachina.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/BirdMan.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
       mReadMovieDetails();
       mSetValuesInGUI();
       mLoadGUIControls();
       mLoadMovieName();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
         mCreateGUIControls();
        txtMoviename.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate= true;
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       mReadMovieDetails();
       mSetValuesInGUI();
       mEditGUIControls();
       txtMoviename.requestFocusInWindow();
       btnDelete.setText("Cancel");
       boolEdit = true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
   if(boolCreate==true)
       {
           if(txtMoviename.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null, "The field can not be left empty");
               txtMoviename.requestFocusInWindow();
           }
           else if(txtGenre.getText().equals("")){
               JOptionPane.showMessageDialog(null, "The field can not be left empty");
               txtGenre.requestFocusInWindow();
           }
           else
           {
            mGetValuesFromGUI();
            mSetValuesToUpperCase();
            mcheckIfItemExistinTable();
             
            if(boolRecordExists==true)
            {
                
             boolRecordExists=false;
             JOptionPane.showMessageDialog(null, "Movie already Exists");
            }
            else if (boolRecordExists==false)
            {
                boolCreate = false;
                mCreateMovie();
                mClearTextFields();
                mClearVariables();
                mClearComboBox();
                mLoadMovieName();
                mLoadGUIControls();
            }}}
       btnDelete.setText("Delete");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    if("Delete".equals(btnDelete.getText()))
{
    
    mReadMovieDetails();
    mDeleteMovie();
    mClearComboBox();
    mClearVariables();
    mLoadMovieName();
}
else if("Cancel".equals(btnDelete.getText()))
{
    mClearTextFields();
    mClearVariables();
    mClearComboBox();
    mLoadMovieName();
    mLoadGUIControls();
    btnDelete.setText("Delete");
}
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cboMovienameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMovienameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMovienameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMoviename;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtGenre;
    private javax.swing.JTextField txtMoviename;
    // End of variables declaration//GEN-END:variables
}
