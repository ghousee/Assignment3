/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.ImageIcon;

/**
 *
 * @author mgmoh
 */
public class Patient {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String message;
    private String patientType;
    private String gender; 
    private ImageIcon photo;
    private String dateOfBirth;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Patient(String firstName, String lastName, int age, String email, String message, String patientType, String gender, ImageIcon photo, String dateOfBirth) { //using the parametrized Constructor
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.message = message;
        this.patientType = patientType;
        this.gender = gender;
        this.photo = photo;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient() {
    }

    
    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", patientType='" + patientType + '\'' +
                ", gender='" + gender + '\'' +
                ", photo=" + photo +
                '}';
    }
}
