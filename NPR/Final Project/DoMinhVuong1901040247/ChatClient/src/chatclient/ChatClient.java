/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chatclient;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Xoaic
 */
public class ChatClient extends javax.swing.JFrame {
    String ID, clientID = "";
    DataInputStream dis;
    DataOutputStream dos;
    DefaultListModel dlm;
    /**
     * Creates new form ChatClient
     */
    public ChatClient() {
        initComponents();
    }
    
    ChatClient(String id, Socket s) {
        ID = id;
        try {
            initComponents();
            dlm = new DefaultListModel();
            userList.setModel(dlm);
            idLabel.setText(id);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
            new Read().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class Read extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    String m = dis.readUTF();
                    Decoder decoder = Base64.getDecoder();
                    byte[] bytes = decoder.decode(m);
                    m = new String(bytes);
                    if (m.contains(":;.,/=")) {
                        m = m.substring(6);
                        dlm.clear();
                        StringTokenizer st = new StringTokenizer(m, ",");
                        while (st.hasMoreTokens()) {
                            String u = st.nextToken();
                            if (!ID.equals(u)) {
                                dlm.addElement(u);
                            }
                        }
                    } else {
                        msgBox.append("" + m + "\n");
                    }
                } catch (Exception e) {
                    break;
                }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        selectAll = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgBox = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        textBox = new javax.swing.JTextField();
        uploadBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        userList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Welcome :");

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idLabel.setText("......................");

        selectAll.setBackground(new java.awt.Color(255, 153, 255));
        selectAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selectAll.setText("Chat All");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });

        msgBox.setEditable(false);
        msgBox.setBackground(new java.awt.Color(204, 255, 255));
        msgBox.setColumns(20);
        msgBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        msgBox.setRows(5);
        jScrollPane1.setViewportView(msgBox);

        sendBtn.setBackground(new java.awt.Color(255, 204, 153));
        sendBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        textBox.setBackground(new java.awt.Color(204, 255, 255));
        textBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textBox.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        uploadBtn.setBackground(new java.awt.Color(255, 153, 153));
        uploadBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uploadBtn.setText("File");
        uploadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadBtnActionPerformed(evt);
            }
        });

        userList.setBackground(new java.awt.Color(204, 255, 255));
        userList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                userListValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(userList);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Chat Client");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(uploadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textBox, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(selectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel)
                    .addComponent(selectAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textBox)
                    .addComponent(uploadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Encoder encoder = Base64.getEncoder();
        String i = "Closinggggggggggggg";
        String es = encoder.encodeToString(i.getBytes());
        
        try {
            dos.writeUTF(es);
            this.dispose();
        } catch (IOException e) {}
    }//GEN-LAST:event_formWindowClosing

    private void userListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userListValueChanged
        // TODO add your handling code here:
        clientID = (String)userList.getSelectedValue();
    }//GEN-LAST:event_userListValueChanged

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        Encoder encoder = Base64.getEncoder();
        try {
            String m = textBox.getText(), mm = m;
            String cID = clientID;
            if (!clientID.isEmpty()) {
                m = "#123456789" + cID + ":" + mm;
                String es = encoder.encodeToString(m.getBytes());
                dos.writeUTF(es);
                textBox.setText("");
                msgBox.append(ID + ": " + mm + "\n");
            } else {
                String es = encoder.encodeToString(m.getBytes());
                dos.writeUTF(es);
                textBox.setText("");
                msgBox.append(ID + ": " + mm + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "User does not exist anymore!");
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        // TODO add your handling code here:   
        userList.removeSelectionInterval(0, 99);
        clientID = "";
    }//GEN-LAST:event_selectAllActionPerformed

    private void uploadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        filechooser.setDialogTitle("Choose your file");
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // below code selects the file 
        int returnval = filechooser.showOpenDialog(this);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            // BufferedImage bi;
//            try {
                // Display the image in chatBox
                // bi = ImageIO.read(file);
            String filePath = file.toString();
            if (filePath.contains("\\"))
                textBox.setText(filePath.substring(filePath.lastIndexOf("\\")+1) + " ");
            else textBox.setText(filePath + " ");
//            } catch (IOException e) {
//                e.printStackTrace(); // todo: implement proper error handeling
//            }
            this.pack();
        }
    }//GEN-LAST:event_uploadBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientConnector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea msgBox;
    private javax.swing.JButton selectAll;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField textBox;
    private javax.swing.JButton uploadBtn;
    private javax.swing.JList<String> userList;
    // End of variables declaration//GEN-END:variables
}