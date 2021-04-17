/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hprxs3b161;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author lafmah1
 */
public class ScheduledTask extends javax.swing.JInternalFrame {

    /**
     * Creates new form NewJInternalFrame
     */
    public ScheduledTask() {
        initComponents();
        mLoadGUIControls();
        mLoadSecurity();
        mLoadUser();
        mLoadControl();
    }
    
     Boolean boolCreate = false;
     Boolean boolRecordExists = false;
     String strName;
     String strGender;
     String strDesignation;
     String strUsername;
   
    String strSecurity;
    String strStatus;
    String intCasenumber;
    String strClientname;
    String strComplianttype;
    String strNoPeople;
    String strLocation;


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("abcsecurity?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        tasksQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT t FROM Tasks t");
        tasksList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tasksQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtClientName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtComplaintType = new javax.swing.JTextField();
        txtLocation = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnUpdatedTask = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cboSecurity = new javax.swing.JComboBox<>();
        btnUpdateDetails = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCaseNumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNoPeople = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jplUserdetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDesignation = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tasks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tasksList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${allocatedSecurity}"));
        columnBinding.setColumnName("Allocated Security");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${status}"));
        columnBinding.setColumnName("Status");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${clientName}"));
        columnBinding.setColumnName("Client Name");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${complaintType}"));
        columnBinding.setColumnName("Complaint Type");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${noOfPeople}"));
        columnBinding.setColumnName("No Of People");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${location}"));
        columnBinding.setColumnName("Location");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${caseNumber}"));
        columnBinding.setColumnName("Case Number");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Task Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel3.setText("Status");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allocated", "Resolved", "Pending", " " }));

        jLabel7.setText("Client Name");

        jLabel6.setText("Complaint Type");

        jLabel8.setText("Location");

        btnUpdatedTask.setText("Save");
        btnUpdatedTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatedTaskActionPerformed(evt);
            }
        });

        jLabel10.setText("Allocate Security");

        btnUpdateDetails.setText("Update Details");
        btnUpdateDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateDetailsActionPerformed(evt);
            }
        });

        jLabel11.setText("Case Number");

        jLabel12.setText("No. of People Involved");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(btnUpdateDetails)
                            .addComponent(jLabel11))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdatedTask)
                            .addComponent(txtClientName)
                            .addComponent(txtLocation)
                            .addComponent(txtComplaintType)
                            .addComponent(cboStatus, 0, 189, Short.MAX_VALUE)
                            .addComponent(cboSecurity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCaseNumber)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(txtNoPeople, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cboSecurity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtComplaintType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtNoPeople, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaseNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdatedTask)
                    .addComponent(btnUpdateDetails))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jplUserdetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel1.setText("Name");

        jLabel4.setText("Gender");

        jLabel5.setText("Designation");

        jLabel9.setText("Username");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jplUserdetailsLayout = new javax.swing.GroupLayout(jplUserdetails);
        jplUserdetails.setLayout(jplUserdetailsLayout);
        jplUserdetailsLayout.setHorizontalGroup(
            jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplUserdetailsLayout.createSequentialGroup()
                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplUserdetailsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jplUserdetailsLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtDesignation)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplUserdetailsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGender, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(txtName)))))
                    .addGroup(jplUserdetailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUpdate)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jplUserdetailsLayout.setVerticalGroup(
            jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplUserdetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jplUserdetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(btnUpdate)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnCancel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jplUserdetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jplUserdetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Task Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(498, 498, 498)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void mLoadSecurity()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/abcsecurity";
        String strDBUser = "root";
        String strDBPassword= "";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery="Select Name FROM user Where Designation='"+ "Security"+"'";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
               cboSecurity.addItem(rs.getString(1));
               
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
        }}
    
   private void mLoadUser()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/abcsecurity";
        String strDBUser = "root";
        String strDBPassword= "Password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        
        try
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery="Select Name,Gender,Designation,Username FROM user Where Designation='"+ "Security"+"'";
           stStatement.execute(strQuery);
           rs=stStatement.getResultSet();
           
           while(rs.next())
           {
           txtName.setText(rs.getString(1));
           txtGender.setText(rs.getString(2));
           txtDesignation.setText(rs.getString(3));
           txtUsername.setText(rs.getString(4));
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
        }}
   private void mcheckIfItemExistinTable()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/abcsecurity";
        String strDBUser = "root";
        String strDBPassword= "Password";
        java.sql.Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rs= null;
        try 
        {
           conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
           stStatement = conMySQLConnectionString.createStatement();
           String strQuery = "Select * from tasks where AllocatedSecurity='"+strSecurity+"' and Client_Name='"+strClientname+"' and ComplaintType='"+strComplianttype+"'and Location='"+strLocation+"'";
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
  
               private void mUpdateTask()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL =  "jdbc:mysql://localhost:3306/abcsecurity";
        String User = "root";
        String Password= "Password";
        
        try
        {

           conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
           Statement myStatement=conMySQLConnectionString.createStatement();
           String sqlinsert = "Update tasks SET  AllocatedSecurity= '"+strSecurity+"',Status='"+strStatus+"',Client_Name='"+strClientname+"',ComplaintType='"+strComplianttype+"',NoOfPeople='"+strNoPeople+"',Location='"+strLocation+"' WHERE Case_Number='"+intCasenumber+"'";
           myStatement.execute(sqlinsert);
           myStatement.close();
          
           JOptionPane.showMessageDialog(null, "Complete");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }     
  private void mUpdateUser()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL =  "jdbc:mysql://localhost:3306/abcsecurity";
        String User = "root";
        String Password= "Password";
        
        try
        {
            
           conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
           Statement myStatement=conMySQLConnectionString.createStatement();
           String sqlupdate = "Update user SET Name='"+strName+"',Gender='"+strGender+"',Designation='"+strDesignation+"' WHERE Username='"+strUsername+"'";
           
           myStatement.execute(sqlupdate);
           myStatement.close();
           
           JOptionPane.showMessageDialog(null, "Complete");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
  
   private void mLoadGUIControls()
      {
          btnUpdate.setVisible(false);
          txtName.setEnabled(false);
          txtGender.setEnabled(false);
          txtDesignation.setEnabled(false);
          txtUsername.setEnabled(false);
      }
               private void mLoadEnableControls()
      {   
             btnUpdate.setVisible(true);
             txtName.setEnabled(true);
             txtGender.setEnabled(true);
             txtDesignation.setEnabled(true);
             txtUsername.setEnabled(false);
          }
               
    private void mGetValuesFromGUI()         
    {
        strName = txtName.getText();
        strGender =txtGender.getText();
        strDesignation = txtDesignation.getText();
        strUsername =  txtUsername.getText();
    }
    private void mGetValuesFromtask() 
        {
        strSecurity = cboSecurity.getSelectedItem().toString();
        strStatus = cboStatus.getSelectedItem().toString();
        strClientname =  txtClientName.getText();
        strComplianttype = txtComplaintType.getText();
        strNoPeople = txtNoPeople.getText();
        strLocation = txtLocation.getText();
        intCasenumber = txtCaseNumber.getText();
    }
    private void mClearTextFields()
    {
       
//        txtName.setText("");
//        txtGender.setText("");
//        txtDesignation.setText("");
//        txtUsername.setText("");
       
        txtClientName.setText("");
        txtComplaintType.setText("");
        txtNoPeople.setText("");
        txtLocation.setText("");
        txtCaseNumber.setText("");
    }

          private void mClearComboBoxStatus()
    {
        
        cboStatus.setSelectedIndex(0);
    }
   
   private void mLoadControl()
   {
       btnUpdatedTask.setVisible(false);
   }
    
    
    
    private void btnUpdatedTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatedTaskActionPerformed
        if(boolCreate==true)
        {
            if(cboSecurity.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                cboSecurity.requestFocusInWindow();
            }
            else if(cboStatus.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                cboStatus.requestFocusInWindow();
            }
            else if(txtClientName.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtClientName.requestFocusInWindow();
            }
            else if(txtComplaintType.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtComplaintType.requestFocusInWindow();
            }
            else if(txtLocation.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtLocation.requestFocusInWindow();
            }
            else if(txtCaseNumber.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtCaseNumber.requestFocusInWindow();
            }

            else
            {
                mGetValuesFromtask();
                //                mcheckIfItemExistinTable();

                if(boolRecordExists==true)
                {

                    boolRecordExists=false;
                    JOptionPane.showMessageDialog(null, "Already registered");
                }
                else if (boolRecordExists==false)
                {
                    boolCreate = false;
                    mGetValuesFromtask();
                    mUpdateTask();
                    mClearTextFields();
                    mLoadSecurity();
                    mClearComboBoxStatus();
                    mLoadControl();

                }}}
    }//GEN-LAST:event_btnUpdatedTaskActionPerformed

    private void btnUpdateDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateDetailsActionPerformed
        btnUpdatedTask.setVisible(true);
        boolCreate= true;
    }//GEN-LAST:event_btnUpdateDetailsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(boolCreate==true)
        {
            if(txtName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtName.requestFocusInWindow();
            }
            else if(txtGender.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtGender.requestFocusInWindow();
            }
            else if(txtDesignation.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtDesignation.requestFocusInWindow();
            }
            else if(txtUsername.getText().equals("")){
                JOptionPane.showMessageDialog(null, "The field can not be left empty");
                txtUsername.requestFocusInWindow();
            }

            else
            {
                mGetValuesFromGUI();
                mUpdateUser();
                mLoadGUIControls();

            }}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        boolCreate= true;
        mLoadEnableControls();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        mLoadGUIControls();
    }//GEN-LAST:event_btnCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateDetails;
    private javax.swing.JButton btnUpdatedTask;
    private javax.swing.JComboBox<String> cboSecurity;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jplUserdetails;
    private java.util.List<hprxs3b161.Tasks> tasksList;
    private javax.persistence.Query tasksQuery;
    private javax.swing.JTextField txtCaseNumber;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtComplaintType;
    private javax.swing.JTextField txtDesignation;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNoPeople;
    private javax.swing.JTextField txtUsername;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}