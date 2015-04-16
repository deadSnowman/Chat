/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc331.sethathomas.chat;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Create a Server to respond to the Client
 *
 * @version 2015-23-3
 * @author Seth A. Thomas
 */
public class PropertiesDialog extends javax.swing.JDialog {

  private final ChatGui chat;
  
  /**
   * Creates new form PropertiesDialog
   */
  public PropertiesDialog(ChatGui parent, boolean modal) {
    super(parent, modal);
    this.chat = parent;
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel1 = new javax.swing.JPanel();
    jRadioButtonClient = new javax.swing.JRadioButton();
    jRadioButtonServer = new javax.swing.JRadioButton();
    jTextFieldServerIP = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jButtonSet = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jTextFieldPort = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    jTextFieldNick = new javax.swing.JTextField();
    jLabelCliServ = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Properties"));

    buttonGroup1.add(jRadioButtonClient);
    jRadioButtonClient.setSelected(true);
    jRadioButtonClient.setText("Client");
    jRadioButtonClient.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jRadioButtonClientActionPerformed(evt);
      }
    });

    buttonGroup1.add(jRadioButtonServer);
    jRadioButtonServer.setText("Server");

    jTextFieldServerIP.setText("127.0.0.1");
    jTextFieldServerIP.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldServerIPActionPerformed(evt);
      }
    });

    jLabel1.setText("Server IP");

    jButtonSet.setText("Set");
    jButtonSet.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonSetActionPerformed(evt);
      }
    });

    jLabel2.setText("Port");

    jTextFieldPort.setText("6000");
    jTextFieldPort.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldPortActionPerformed(evt);
      }
    });

    jLabel3.setText("Nick");

    jTextFieldNick.setText("Seth");

    jLabelCliServ.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
    jLabelCliServ.setForeground(new java.awt.Color(255, 0, 0));
    jLabelCliServ.setText("Not assigned");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jTextFieldNick))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonSet, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButtonServer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jRadioButtonClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jTextFieldServerIP, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addComponent(jTextFieldPort))
              .addComponent(jLabelCliServ, javax.swing.GroupLayout.Alignment.TRAILING))))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jTextFieldNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jRadioButtonClient)
          .addComponent(jTextFieldServerIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jRadioButtonServer)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(jTextFieldPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jButtonSet, javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabelCliServ)
            .addContainerGap())))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void jTextFieldServerIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldServerIPActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextFieldServerIPActionPerformed

  private void jRadioButtonClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonClientActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jRadioButtonClientActionPerformed

  private void jButtonSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSetActionPerformed
    // TODO add your handling code here:
    ExecutorService es = Executors.newCachedThreadPool();
    
    try {
      if(jRadioButtonClient.isSelected()) {
	
	// Destroy previous server/client
	try {
	  if(this.chat.getSrv() != null) this.chat.getSrv().stop();
	  if(this.chat.getCli() != null) this.chat.getCli().stop();
	} catch (IOException ex) {
	  Logger.getLogger(PropertiesDialog.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	// Save and start client
	this.chat.setCli(new Client(jTextFieldServerIP.getText(), Integer.parseInt(jTextFieldPort.getText()), this.chat, jTextFieldNick.getText()));
	es.submit(this.chat.getCli());
	jLabelCliServ.setText("Client");
	jLabelCliServ.setForeground(Color.green);
	this.chat.setTitle("Chat - Client");
      }
      else {
	// Destroy previous server/client
	try {
	  if(this.chat.getSrv() != null) this.chat.getSrv().stop();
	  if(this.chat.getCli() != null) this.chat.getCli().stop();
	} catch (IOException ex) {
	  Logger.getLogger(PropertiesDialog.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	// Save and start server
	this.chat.setSrv(new Server(Integer.parseInt(jTextFieldPort.getText()), this.chat, jTextFieldNick.getText()));
	es.submit(this.chat.getSrv());
	jLabelCliServ.setText("Server");
	jLabelCliServ.setForeground(Color.green);
	this.chat.setTitle("Chat - Server");
      }
    }
    catch(NumberFormatException e) {
      System.out.println("Port number is incorrect");
    }
    es.shutdown();
  }//GEN-LAST:event_jButtonSetActionPerformed

  private void jTextFieldPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jTextFieldPortActionPerformed

  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton jButtonSet;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabelCliServ;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JRadioButton jRadioButtonClient;
  private javax.swing.JRadioButton jRadioButtonServer;
  private javax.swing.JTextField jTextFieldNick;
  private javax.swing.JTextField jTextFieldPort;
  private javax.swing.JTextField jTextFieldServerIP;
  // End of variables declaration//GEN-END:variables
}