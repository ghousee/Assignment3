/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.Patient;
import javax.swing.*;
import javax.swing.SpinnerDateModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;




/**
 *
 * @author mgmoh
 */
public class FormPage extends javax.swing.JPanel {
    private File photoFile;
    private Date selectedDate;

    /**
     * Creates new form FormPage
     */
    
    JPanel bottomJPanel;
    public FormPage(JPanel bottomJPanel) {
        initComponents();
                
        this.bottomJPanel = bottomJPanel;

        var txtMessage = "";
        photoJButton.addActionListener(e -> {
            JFileChooser file = new JFileChooser();
            if(file.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                try{
                    
                    BufferedImage img = ImageIO.read(file.getSelectedFile());
                    Image edited_image = img.getScaledInstance(60, 80, Image.SCALE_SMOOTH);
                    ImageIcon icon = new ImageIcon (edited_image);
                    if(edited_image != null){
                        photoFile = file.getSelectedFile();
                        photoDisplayLabel.setText(file.getSelectedFile().getAbsolutePath());
                        photoDisplayLabel.setIcon(new ImageIcon(edited_image));
                    }
                    JOptionPane.showMessageDialog(this,txtMessage, "Photo Uploaded.", JOptionPane.ERROR_MESSAGE, icon);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(this,"Please upload image properly.");
                    ex.printStackTrace();
                }
            }
        });   
        submitJBtn.addActionListener(e -> {

        });
        selectDateButton.addActionListener(e -> selectDate());
       
    }
    
    
        private void selectDate() {
    
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(selectedDate != null ? selectedDate : new Date());

        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
        dateSpinner.setEditor(dateEditor);

    
        int option = JOptionPane.showConfirmDialog(this, dateSpinner, "Select Date", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            selectedDate = (Date) dateSpinner.getValue(); // Get the selected date
            System.out.println("Selected Date: " + new SimpleDateFormat("yyyy-MM-dd").format(selectedDate));
        }
    }
    
        private boolean validateInputs(){
            
        if(firstNameField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter First Name", "First Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(lastNameField.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter Last Name", "Last Name Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (ageField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Age", "Age Missing", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int age = Integer.parseInt(ageField.getText().trim());
            if (age <= 0) {
                JOptionPane.showMessageDialog(this, "Age must be a positive number", "Age Error(Negative Number not allowed)", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a valid number", "Age Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String email = emailField.getText().trim();
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        if(!pattern.matcher(email).matches()){
            JOptionPane.showMessageDialog(this, "Invalid email address format. Please enter the email again", "Email not entered", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String selectedPatientType = (String) patientTypeComboBox.getSelectedItem();
        if (selectedPatientType.equals("Select")) {
            JOptionPane.showMessageDialog(this, "Please select a patient type", "Patient Type Selection Error", JOptionPane.ERROR_MESSAGE);
            return false;        
        }

        if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected() && !otherRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a Gender.", "Gender Selection Error", JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        if (photoFile == null) {
            JOptionPane.showMessageDialog(this, "Please select a photo", "Photo selection error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
            String message = messageArea.getText().trim();
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a message", "Message not entered", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please select a date of birth", "Date of Birth not entered", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (selectedDate.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Date of birth must be before today's date", "Date of Birth Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

        }
        
//        private void displayUserProfile(Patient patient) {
//        String userInfo = String.format("First Name: %s\nLast Name: %s\nAge: %s\nEmail: %s\nPhoto: %s",
//                firstNameField.getText(), lastNameField.getText(), ageField.getText(), emailField.getText(), photoFile.getName());

//        JOptionPane.showMessageDialog(this, userInfo, "User Profile", JOptionPane.INFORMATION_MESSAGE);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderSelection = new javax.swing.ButtonGroup();
        patientRegForm = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        patientTypeComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        otherRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        photoJButton = new javax.swing.JButton();
        photoDisplayLabel = new javax.swing.JLabel();
        submitJBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        messageArea = new javax.swing.JTextField();
        DOBJLabel = new javax.swing.JLabel();
        selectDateButton = new javax.swing.JButton();

        patientRegForm.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        patientRegForm.setText("Patient Registration Form");

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("Age:");

        jLabel5.setText("Email:");

        ageField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Patient Type:");

        patientTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Appointment", "Walk-In" }));

        jLabel1.setText("Gender:");

        genderSelection.add(maleRadioButton);
        maleRadioButton.setText("Male");

        genderSelection.add(femaleRadioButton);
        femaleRadioButton.setText("Female");
        femaleRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleRadioButtonActionPerformed(evt);
            }
        });

        genderSelection.add(otherRadioButton);
        otherRadioButton.setText("Other");

        jLabel7.setText("Profile Picture:");

        photoJButton.setText("Select Image");

        submitJBtn.setText("Submit");
        submitJBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Message:");

        DOBJLabel.setText("Date of Birth");

        selectDateButton.setText("Select Date of Birth");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(DOBJLabel))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ageField)
                            .addComponent(emailField)
                            .addComponent(firstNameField)
                            .addComponent(lastNameField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(maleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(femaleRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(photoJButton)
                                    .addComponent(otherRadioButton))
                                .addGap(197, 197, 197)
                                .addComponent(photoDisplayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(patientTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(356, 356, 356))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(selectDateButton)
                                .addGap(373, 373, 373))
                            .addComponent(messageArea))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(patientRegForm)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(503, 503, 503)
                .addComponent(submitJBtn)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(patientRegForm)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(patientTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(maleRadioButton)
                            .addComponent(femaleRadioButton)
                            .addComponent(otherRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(photoJButton)))
                    .addComponent(photoDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messageArea, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DOBJLabel)
                    .addComponent(selectDateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(submitJBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ageFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageFieldActionPerformed

    private void femaleRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleRadioButtonActionPerformed

    private void submitJBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJBtnActionPerformed
        // TODO add your handling code here:
        if (validateInputs()) {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            int age = Integer.parseInt(ageField.getText().trim());
            String email = emailField.getText().trim();
            var message = messageArea.getText().trim();
            String patientType = (String) patientTypeComboBox.getSelectedItem();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            var photo = (ImageIcon) photoDisplayLabel.getIcon();
            String dateOfBirth = selectedDate != null ? new SimpleDateFormat("yyyy-MM-dd").format(selectedDate) : "Not Selected";

//            Patient patient = new Patient(firstNameField.getText(), lastNameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), messageArea.getText(), (String)patientTypeComboBox.getSelectedItem(), cmbProgram.getSelectedItem(), (ImageIcon) photoLabel.getIcon());
            Patient patient = new Patient(firstName, lastName, age, email, message, patientType, gender, photo, dateOfBirth);
//            displayUserProfile(patient);
            
            PatientDetails PatientDetails = new PatientDetails(patient);
            bottomJPanel.add(PatientDetails);
            CardLayout cl = (CardLayout)bottomJPanel.getLayout();
            cl.next(bottomJPanel);
        }
        
        
    }//GEN-LAST:event_submitJBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DOBJLabel;
    private javax.swing.JTextField ageField;
    private javax.swing.JTextField emailField;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.ButtonGroup genderSelection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JTextField messageArea;
    private javax.swing.JRadioButton otherRadioButton;
    private javax.swing.JLabel patientRegForm;
    private javax.swing.JComboBox<String> patientTypeComboBox;
    private javax.swing.JLabel photoDisplayLabel;
    private javax.swing.JButton photoJButton;
    private javax.swing.JButton selectDateButton;
    private javax.swing.JButton submitJBtn;
    // End of variables declaration//GEN-END:variables
}
