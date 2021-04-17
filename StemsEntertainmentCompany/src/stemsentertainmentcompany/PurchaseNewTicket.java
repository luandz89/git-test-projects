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
public class PurchaseNewTicket extends javax.swing.JInternalFrame {

    /**
     * Creates new form PurchaseNewTicket
     */
    public PurchaseNewTicket() {
        initComponents();
         mLoadMovieName();
         mLoadTime();
    }
 Boolean boolRecordExists = false;
    Boolean boolEdit = false;
    Boolean boolCreate = false;
    String strMovieName;
    String strTime;
    int intMovieID;
    int intTicketNo;
       
    private void mClearVariables()
    {
   
   intTicketNo=Integer.parseInt("");
    }
    private void mGetValuesFromGUI()
    {
        strMovieName = cboMoviename.getSelectedItem().toString();
        strTime = cboTime.getSelectedItem().toString();
        intTicketNo = Integer.parseInt(txtTicketNo.getText());
    }


    private void mSetValuesInGUI()
    {
       cboMoviename.getSelectedItem();
       cboTime.getSelectedItem();
    }
    
    private void mClearTextFields()
    {
       
        txtTicketNo.setText("");
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
           String strQuery = "Select * from booked_sessions where Ticket_Number='"+intTicketNo+"' and Movie_name='" +strMovieName+ "'and Time_Booked='"+strTime+"'";
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
      private void mCreateTicket()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL =  "jdbc:mysql://localhost:3306/stems";
        String User = "root";
        String Password= "password";
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
           Statement myStatement=conMySQLConnectionString.createStatement();
           String sqlinsert = "insert into booked_sessions(Ticket_number,Movie_name,Time_booked)"+"values('"+intTicketNo+"','"+strMovieName+"','"+strTime+"')";
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
               private void mLoadTime()
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
           String strQuery="Select Times FROM times";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
               cboTime.addItem(rs.getString(1));
               
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
           String strQuery = "Update booked_sessions SET Ticket_Number='"+intTicketNo+"',Movie_Name='"+strMovieName+"',Time_Booked='"+strTime+"'WHERE ID="+intMovieID;
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
          private void mClearComboBox1()
    {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboTime.setModel(model);
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
           
           String strQuery= "Delete from booked_sessions where  Ticket_Number='"+intTicketNo+"'and Movie_Name='"+strMovieName+"'and Time_Booked='"+strTime+"'and ID="+intMovieID;
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
           String strQuery="Select ID,Ticket_Number,Movie_Name,Time_booked from Booked_Sessions where movie_Name='"+ cboMoviename.getSelectedItem().toString()+"'";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
               intMovieID = rs.getInt(1);
               intTicketNo = Integer.parseInt(rs.getString(2));
               strMovieName= rs.getString(3);
               strTime = rs.getString(4);
               
               
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
          
          txtTicketNo.setEnabled(true);
          cboTime.setEnabled(true);
          cboMoviename.setEnabled(true);
          btnBook.setEnabled(true);
          btnLoad.setEnabled(true);
          btnEdit.setEnabled(true);
          btnSave.setEnabled(false);
          btnDelete.setEnabled(false);
      }
      private void mEditGUIControls()
      {
           txtTicketNo.setEnabled(true);
          cboTime.setEnabled(true);
          cboMoviename.setEnabled(true);
          btnBook.setEnabled(false);
          btnLoad.setEnabled(false);
          btnEdit.setEnabled(false);
          btnSave.setEnabled(true);
          btnDelete.setEnabled(true);
      }
      private void mSaveGUIControls()
      { 
          txtTicketNo.setEnabled(false);
          cboTime.setEnabled(true);
          cboMoviename.setEnabled(true);
          btnBook.setEnabled(true);
          btnLoad.setEnabled(true);
          btnEdit.setEnabled(true);
          btnSave.setEnabled(false);
          btnDelete.setEnabled(false);
      }
      private void mCreateGUIControls()
      {
          txtTicketNo.setEnabled(true);
          cboTime.setEnabled(true);
          cboMoviename.setEnabled(true);
          btnBook.setEnabled(false);
          btnLoad.setEnabled(false);
          btnEdit.setEnabled(false);
          btnSave.setEnabled(true);
          btnDelete.setEnabled(true);
      }
      private void mDeleteControls()
      {   
          txtTicketNo.setEnabled(false);
          cboTime.setEnabled(true);
          cboMoviename.setEnabled(true);
          btnBook.setEnabled(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboMoviename = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboTime = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtTicketNo = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setClosable(true);
        setIconifiable(true);
        setTitle("Purchase New Ticket");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/AmericanSniper.jpg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/BirdMan.jpg"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/Taken3.jpg"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stemsentertainmentcompany/exMachina.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 2, 14)); // NOI18N
        jLabel1.setText("Select movie:");

        cboMoviename.setBackground(new java.awt.Color(51, 51, 51));
        cboMoviename.setForeground(new java.awt.Color(255, 255, 0));

        jLabel3.setFont(new java.awt.Font("Goudy Old Style", 2, 14)); // NOI18N
        jLabel3.setText("Select viewing time/session:");

        cboTime.setBackground(new java.awt.Color(51, 51, 51));
        cboTime.setForeground(new java.awt.Color(255, 255, 0));
        cboTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Goudy Old Style", 2, 14)); // NOI18N
        jLabel2.setText("Ticket Number:");

        btnBook.setBackground(new java.awt.Color(51, 51, 51));
        btnBook.setForeground(new java.awt.Color(255, 255, 0));
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnLoad.setBackground(new java.awt.Color(51, 51, 51));
        btnLoad.setForeground(new java.awt.Color(255, 255, 0));
        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(51, 51, 51));
        btnEdit.setForeground(new java.awt.Color(255, 255, 0));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(51, 51, 51));
        btnSave.setForeground(new java.awt.Color(255, 255, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(51, 51, 51));
        btnDelete.setForeground(new java.awt.Color(255, 255, 0));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Goudy Old Style", 2, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(cboMoviename, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTicketNo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboMoviename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTicketNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(btnBook)
                .addGap(48, 48, 48)
                .addComponent(btnLoad)
                .addGap(48, 48, 48)
                .addComponent(btnEdit)
                .addGap(48, 48, 48)
                .addComponent(btnSave)
                .addGap(52, 52, 52)
                .addComponent(btnDelete)
                .addGap(45, 45, 45)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        mCreateGUIControls();
        txtTicketNo.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolCreate= true;
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed

        mSetValuesInGUI();
        mLoadGUIControls();
        mLoadMovieName();
        mLoadTime();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        mReadMovieDetails();
        mSetValuesInGUI();
        mEditGUIControls();
        txtTicketNo.requestFocusInWindow();
        btnDelete.setText("Cancel");
        boolEdit = true;
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(boolCreate==true)
        {
            if(cboMoviename.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                cboMoviename.requestFocusInWindow();
            }
            else if(cboTime.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                cboTime.requestFocusInWindow();
            }
            else if(txtTicketNo.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtTicketNo.requestFocusInWindow();
            }
            else
            {
                mGetValuesFromGUI();
                //mSetValuesToUpperCase();
                mcheckIfItemExistinTable();

                if(boolRecordExists==true)
                {

                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "Already Booked");
                }
                else if (boolRecordExists==false)
                {
                    boolCreate = false;
                    mCreateTicket();
                    mClearTextFields();
                    mClearVariables();
                    mClearComboBox();
                    mClearComboBox1();
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
            mClearComboBox1();
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

    private void cboTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTimeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cboMoviename;
    private javax.swing.JComboBox<String> cboTime;
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
    private javax.swing.JTextField txtTicketNo;
    // End of variables declaration//GEN-END:variables
}
