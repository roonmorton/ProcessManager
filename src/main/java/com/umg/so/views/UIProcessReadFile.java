/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umg.so.views;

import com.umg.so.processmanager.models.ProcessModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ronaldo Lemus
 */
public class UIProcessReadFile extends javax.swing.JFrame implements Runnable {

    private ProcessModel process;
    private String fileName;
    private FileReader fr;
    private BufferedReader br;
    private File archivo;

    /**
     * Creates new form UIProcessOne
     */
    public UIProcessReadFile() {
        initComponents();
        this.process = new ProcessModel("File Reader", "Lectura de Archivo");
        fileName = "file.txt";
        this.txtContent.setLineWrap(true);
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(fileName);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            this.txtContent.append("Archivo abierto...\n\n");
        } catch (Exception e) {
            e.printStackTrace();
            this.txtContent.append("\nNo se pudo abrir el archivo");
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lectura de Archivo");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocation(new java.awt.Point(10, 10));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lectura de Archivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(508, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtContent.setEditable(false);
        txtContent.setColumns(1);
        txtContent.setRows(5);
        jScrollPane1.setViewportView(txtContent);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtContent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        int c;
        this.process.setStatus(2);
        System.out.println("Code: " + this.process.getStatusCode());
        try {
            while (this.process.getStatusCode() != 3) {
                if (this.process.getStatusCode() == 2) {
                        c = br.read();
                        if (c == -1) {
                            this.process.setStatus(3);
                            this.txtContent.append("\nFin de lectura...");
                        } else {
                            this.txtContent.append("" + (char) c);
                        }
                }
                Thread.sleep(100L);
            }
        } catch (Exception e) {
            this.process.setStatus(3);
            e.printStackTrace();
            this.txtContent.append("\nOcurrio un error en la lectura... " + e.getMessage());
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public ProcessModel getProcessModel() {
        return this.process;
    }

    public UIProcessReadFile showMe() {
        this.setVisible(true);
        return this;
    }

    public UIProcessReadFile hideMe() {
        this.setVisible(false);
        return this;
    }
    
    public void pause() {
        this.setVisible(false);
        this.process.setStatus(1);
    }

   

    public void go() {
        this.setVisible(true);
        this.process.setStatus(2);
    }

}
