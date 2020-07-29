package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nurse_table")
public class Nurse {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseID;


    @NonNull
    @ColumnInfo(name = "firstname")
    private String firstname;

    @NonNull
    @ColumnInfo(name = "lastname")
    private String lastname;

    @ColumnInfo(name = "department")
    private String department;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public Nurse(){}

    public Nurse(@NonNull int nurseId, @NonNull String firstname, @NonNull String lastname, String department, @NonNull String password){
        this.nurseID = nurseId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.password = password;

    }
    //getter and setter except setter for Nurse ID
    @NonNull
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NonNull String firstname) {
        this.firstname = firstname;
    }

    @NonNull
    public String getLastname() {
        return lastname;
    }

    public void setLastname(@NonNull String lastname) {
        this.lastname = lastname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseID=" + nurseID +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department='" + department + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
