package com.mycompany.newmailboxfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private int idstudent;
    private String FName;
    private String LName;
    private String Address;
    private String Email;

    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Student(int idstudent, String FName, String LName, String address, String email) {
        this.idstudent = idstudent;
        this.FName = FName;
        this.LName = LName;
        Address = address;
        Email = email;
    }
/*
    public Integer getIdstudent() {
        return this.idstudent.get();
    }

    public void setIdstudent(int idstudent) {
        this.idstudent.set(idstudent);
    }

    public String getFName() {
        return this.FName.get();
    }

    public void setFName(String FName) {
        this.FName.set(FName);
    }

    public String getLName() {
        return this.LName.get();
    }

    public void setLName(String LName) {
        this.LName.set(LName);
    }

    public String getAddress() {
        return this.Address.get();
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }

    public String getEmail() {
        return this.Email.get();
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }
*/
}

