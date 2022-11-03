package chatserver;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Xoaic
 */
public class ChatServer extends javax.swing.JFrame {

    /**
     * Creates new form ServerPanel
     */
    ServerSocket ss;
    HashMap clientColl = new HashMap();
    private static final HashMap<String, String> acc = new HashMap<String, String>();
    
    public ChatServer() {
        try {
            initComponents();
            ss = new ServerSocket(2021);
            this.sStatus.setText("Server Started!");
            
            new ClientAccept().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class ClientAccept extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Socket s = ss.accept();
                    Encoder encoder = Base64.getEncoder();
                    Decoder decoder = Base64.getDecoder();

                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    byte[] bytes = decoder.decode(i);
                
                    i = new String(bytes);
                    
                    String id = i.substring(2, i.indexOf(":"));
                    String pass = i.substring(i.indexOf(":")+1);
                    if (i.substring(0,1).equals("0")) {
                        if (acc.containsKey(id)) {
                            if (acc.get(id).equals(pass)) {
                                clientColl.put(id, s);
                                msgBox.append(id + " joined!\n");
                                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                                String es = encoder.encodeToString("".getBytes());
                                dos.writeUTF(es);
                                new MsgRead(s, id).start();
                                new PrepareClientList().start();
                            } else {
                                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                                String es = encoder.encodeToString("The password is not correct...!".getBytes());
                                dos.writeUTF(es);
                            }
                        } else {
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String es = encoder.encodeToString("You are not already registered...!".getBytes());
                            dos.writeUTF(es);
                        }
                    } else {
                        if (acc.containsKey(id)) {
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String es = encoder.encodeToString("You are already registered...!".getBytes());
                            dos.writeUTF(es);
                        } else {
                            clientColl.put(id, s);
                            acc.put(id, pass);
                            msgBox.append(id + " joined!\n");
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            String es = encoder.encodeToString("".getBytes());
                            dos.writeUTF("");
                            new MsgRead(s, id).start();
                            new PrepareClientList().start();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class MsgRead extends Thread {
        Socket s;
        String ID;
        
        MsgRead (Socket s, String ID) {
            this.s = s;
            this.ID = ID;
        }
        @Override
        public void run() {
            while (!clientColl.isEmpty()) {
                try {
                    String i = new DataInputStream(s.getInputStream()).readUTF();
                    Encoder encoder = Base64.getEncoder();
                    Decoder decoder = Base64.getDecoder();
                    byte[] bytes = decoder.decode(i);
                    i = new String(bytes);
                    
                    if (i.equals("Closinggggggggggggg")){
                        clientColl.remove(ID);
                        msgBox.append(ID + " removed!\n");
                        new PrepareClientList().start();
                        Set k = clientColl.keySet();
                        Iterator itr = k.iterator();
                        while (itr.hasNext()) {
                            String key = (String) itr.next();
                            if (!key.equalsIgnoreCase(ID)) {
                                try {
//                                    String es = encoder.encodeToString("".getBytes());
//                                    new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF(es);
                                } catch (Exception e) {
                                    clientColl.remove(key);
                                    msgBox.append(key + " removed!");
                                    new PrepareClientList().start();
                                }
                            }
                        }
                    } else if (i.contains("#123456789")) {
                        i = i.substring(10);
                        StringTokenizer st = new StringTokenizer(i, ":");
                        String id = st.nextToken();
                        i = st.nextToken();
                        try {
                            String es = "";
                            if (ID.equals(id)) {
                                es = encoder.encodeToString((id + ": " + i).getBytes());
                            } else {
                                es = encoder.encodeToString((ID + ": " + i).getBytes());
                            }
                            new DataOutputStream(((Socket)clientColl.get(id)).getOutputStream()).writeUTF(es);
                        } catch (Exception e) {
                            clientColl.remove(id);
                            msgBox.append(id + " removed!");
                            new PrepareClientList().start();
                        }
                    } else {
                        Set k = clientColl.keySet();
                        Iterator itr = k.iterator();
                        while (itr.hasNext()) {
                            String key = (String)itr.next();
                            if (!key.equalsIgnoreCase(ID)) {
                                try {
                                    String es = encoder.encodeToString((ID + ": " + i).getBytes());
                                    new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF(es);
                                } catch (Exception e) {
                                    clientColl.remove(key);
                                    msgBox.append(key + " removed!");
                                    new PrepareClientList().start();
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class PrepareClientList extends Thread {
        @Override
        public void run() {
            try {
                String ids = "";
                Set k = clientColl.keySet();
                Iterator itr = k.iterator();
                while (itr.hasNext()){
                    String key = (String) itr.next();
                    ids += key + ",";
                }
                if (ids.length() != 0) {
                    ids = ids.substring(0, ids.length() - 1);
                }
                itr = k.iterator();
                while (itr.hasNext()) {
                    String key = (String)itr.next();
                    try {
                        Encoder encoder = Base64.getEncoder();
                        String es = encoder.encodeToString((":;.,/=" + ids).getBytes());
                        new DataOutputStream(((Socket)clientColl.get(key)).getOutputStream()).writeUTF(es);
                    } catch (Exception e) {
                        clientColl.remove(key);
                        msgBox.append(key + " removed!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        msgBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        sStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Server");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        msgBox.setEditable(false);
        msgBox.setBackground(new java.awt.Color(204, 255, 255));
        msgBox.setColumns(20);
        msgBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        msgBox.setRows(5);
        jScrollPane1.setViewportView(msgBox);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Server Status :");

        sStatus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sStatus.setText(".................................");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Chat Server");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel2)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sStatus)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgBox;
    private javax.swing.JLabel sStatus;
    // End of variables declaration//GEN-END:variables
}