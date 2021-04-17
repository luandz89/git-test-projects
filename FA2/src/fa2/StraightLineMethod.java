/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fa2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class StraightLineMethod extends javax.swing.JInternalFrame {
   
    double myAssetCost=0;
    double myValue =0;

    public StraightLineMethod() {
        
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Heading = new javax.swing.JLabel();
        CostAsset = new javax.swing.JLabel();
        Estimate = new javax.swing.JLabel();
        AssetLife = new javax.swing.JLabel();
        totalDepriciable = new javax.swing.JLabel();
        annualDeprecaible = new javax.swing.JLabel();
        DeprRate = new javax.swing.JLabel();
        costOfAssetTxt = new javax.swing.JTextField();
        value = new javax.swing.JTextField();
        lifeofAssetTxt = new javax.swing.JTextField();
        depreRateTxt = new javax.swing.JTextField();
        annualTxt = new javax.swing.JTextField();
        totalDepreTxt = new javax.swing.JTextField();
        calc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        clear1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setTitle("Straight Line Method");
        setVisible(true);

        Heading.setFont(new java.awt.Font("Tempus Sans ITC", 1, 30)); // NOI18N
        Heading.setText("Straight Line Method");
        Heading.setToolTipText("");

        CostAsset.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        CostAsset.setText("Cost of the Asset :");

        Estimate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Estimate.setText("Est. Salvage Value :");

        AssetLife.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        AssetLife.setText("Life of the Asset :");

        totalDepriciable.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        totalDepriciable.setText("Total Depriciable Cost :");

        annualDeprecaible.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        annualDeprecaible.setText("Annual Depreciable Amount :");

        DeprRate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        DeprRate.setText("Depreciation Rate :");

        depreRateTxt.setEditable(false);
        depreRateTxt.setBackground(new java.awt.Color(255, 255, 153));

        annualTxt.setEditable(false);
        annualTxt.setBackground(new java.awt.Color(255, 255, 153));

        totalDepreTxt.setEditable(false);
        totalDepreTxt.setBackground(new java.awt.Color(255, 255, 153));

        calc.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        calc.setText("Calculate");
        calc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcActionPerformed(evt);
            }
        });

        jLabel7.setText("%");

        clear1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clear1.setText("Clear");
        clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(calc, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clear1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(annualDeprecaible, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(annualTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalDepriciable, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(totalDepreTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AssetLife, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(lifeofAssetTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Estimate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(value))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(CostAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(costOfAssetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(DeprRate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(depreRateTxt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Heading, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CostAsset, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costOfAssetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Estimate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lifeofAssetTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AssetLife, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDepreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalDepriciable, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annualDeprecaible, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depreRateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeprRate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calc)
                    .addComponent(clear1))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcActionPerformed
        try{
            myAssetCost = Double.parseDouble(costOfAssetTxt.getText());
            myValue = Double.parseDouble(value.getText());
            double total =(myAssetCost-myValue);
            totalDepreTxt.setText(total+" ");
            
            int myAssetLife = Integer.parseInt(lifeofAssetTxt.getText());
            double results = total/myAssetLife;
            annualTxt.setText(results+" ");
            
            double rate = results/total*100;
            depreRateTxt.setText(rate+" ");
            
        }catch (NumberFormatException ex)
        {
            if(myAssetCost <=0||myValue<=0)
            {
                JOptionPane.showMessageDialog(this, "Please enter numerical values greater than 'zero'");
                
                JOptionPane.showMessageDialog(rootPane, "Error: "+ex.getMessage());
            }        
        }
    }//GEN-LAST:event_calcActionPerformed

    private void clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear1ActionPerformed
      costOfAssetTxt.setText("");
      value.setText("");
      lifeofAssetTxt.setText("");
      totalDepreTxt.setText("");
      annualTxt.setText("");
      depreRateTxt.setText("");
    }//GEN-LAST:event_clear1ActionPerformed

  



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssetLife;
    private javax.swing.JLabel CostAsset;
    private javax.swing.JLabel DeprRate;
    private javax.swing.JLabel Estimate;
    private javax.swing.JLabel Heading;
    private javax.swing.JLabel annualDeprecaible;
    private javax.swing.JTextField annualTxt;
    private javax.swing.JButton calc;
    private javax.swing.JButton clear1;
    private javax.swing.JTextField costOfAssetTxt;
    private javax.swing.JTextField depreRateTxt;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField lifeofAssetTxt;
    private javax.swing.JTextField totalDepreTxt;
    private javax.swing.JLabel totalDepriciable;
    private javax.swing.JTextField value;
    // End of variables declaration//GEN-END:variables

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
