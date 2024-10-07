/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import models.Patient;
/**
 *
 * @author mgmoh
 */
public class PatientDetails extends javax.swing.JPanel {

    /**
     * Creates new form PatientDetails
     */
    Patient patient;
    public PatientDetails(Patient patient) {
        initComponents();
        this.patient = patient;
        String PatientInfo = String.format("First Name: %s\nLast Name: %s\nAge: %s\nEmail: %s\nPatientType: %s\nMessage: %s\nPhoto: [Available]\nDate of Birth: %s",
                patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getEmail(), patient.getPatientType(),patient.getMessage(),patient.getPhoto(), patient.getDateOfBirth());
        detailstxt.setText(PatientInfo);

    }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientDetailsForm = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailstxt = new javax.swing.JTextArea();

        patientDetailsForm.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        patientDetailsForm.setText("Patient Details");

        detailstxt.setEditable(false);
        detailstxt.setColumns(20);
        detailstxt.setRows(5);
        jScrollPane1.setViewportView(detailstxt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(patientDetailsForm))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientDetailsForm)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea detailstxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel patientDetailsForm;
    // End of variables declaration//GEN-END:variables
}