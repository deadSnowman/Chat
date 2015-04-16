/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.frostburg.cosc331.sethathomas.chat;

import javax.swing.JTextArea;

/**
 * Create a Server to respond to the Client
 *
 * @version 2015-23-3
 * @author Seth A. Thomas
 */
public class ChatGui extends javax.swing.JFrame {

  public Client cli;
  public Server srv; 
 
  /**
   * Creates new form ChatGui
   */
  public ChatGui() {
    this.cli = null;
    this.srv = null;
    initComponents();
  }

  public Client getCli() {
    return cli;
  }

  public void setCli(Client cli) {
    this.cli = cli;
  }

  public Server getSrv() {
    return srv;
  }

  public void setSrv(Server srv) {
    this.srv = srv;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextAreaChatOutput = new javax.swing.JTextArea();
    jTextFieldChatInput = new javax.swing.JTextField();
    jButtonSend = new javax.swing.JButton();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItemProperties = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();

    jTextField1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1ActionPerformed(evt);
      }
    });

    jButton1.setText("Send");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Chat");

    jTextAreaChatOutput.setEditable(false);
    jTextAreaChatOutput.setColumns(20);
    jTextAreaChatOutput.setRows(5);
    jScrollPane1.setViewportView(jTextAreaChatOutput);

    jTextFieldChatInput.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldChatInputActionPerformed(evt);
      }
    });

    jButtonSend.setText("Send");
    jButtonSend.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonSendActionPerformed(evt);
      }
    });

    jMenu1.setText("File");

    jMenuItemProperties.setText("Properties");
    jMenuItemProperties.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemPropertiesActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItemProperties);

    jMenuBar1.add(jMenu1);

    jMenu2.setText("Edit");
    jMenuBar1.add(jMenu2);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jTextFieldChatInput)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButtonSend)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jTextFieldChatInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButtonSend))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    
  }//GEN-LAST:event_jTextField1ActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
    // TODO add your handling code here:
    if(this.cli != null) {
      this.cli.broadcast("<" + this.cli.getNick() + "> " + jTextFieldChatInput.getText());
      jTextFieldChatInput.setText("");
    }
    else {
      this.srv.broadcast("<" + this.srv.getNick() + "> " + jTextFieldChatInput.getText());
      jTextFieldChatInput.setText("");
    }
  }//GEN-LAST:event_jButtonSendActionPerformed

  private void jMenuItemPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPropertiesActionPerformed
    // TODO add your handling code here:
    PropertiesDialog prop = new PropertiesDialog(this, true);
    prop.setVisible(true);
  }//GEN-LAST:event_jMenuItemPropertiesActionPerformed

  private void jTextFieldChatInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChatInputActionPerformed
    // TODO add your handling code here:
    jButtonSendActionPerformed(evt);
  }//GEN-LAST:event_jTextFieldChatInputActionPerformed

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
      java.util.logging.Logger.getLogger(ChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ChatGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
        //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
	new ChatGui().setVisible(true);
      }
    });
  }

  public JTextArea getjTextAreaChatOutput() {
    return jTextAreaChatOutput;
  }

  public void setjTextAreaChatOutput(JTextArea jTextAreaChatOutput) {
    this.jTextAreaChatOutput = jTextAreaChatOutput;
  }
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButtonSend;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItemProperties;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTextArea jTextAreaChatOutput;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JTextField jTextFieldChatInput;
  // End of variables declaration//GEN-END:variables
}
