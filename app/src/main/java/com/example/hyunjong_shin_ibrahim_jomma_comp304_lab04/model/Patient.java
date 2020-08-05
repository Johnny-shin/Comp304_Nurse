package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

//@Entity(tableName = "patient_table", foreignKeys = @ForeignKey(entity = Nurse.class,
//        parentColumns = "nurseId",
//        childColumns = "patientId",
//        onDelete = ForeignKey.CASCADE))


@Entity(tableName = "patient_table")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "patientId")
    private int patientId;

    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseId;


    @NonNull
    @ColumnInfo(name = "firstname")
    private String firstname;


    @NonNull
    @ColumnInfo(name = "lastname")
    private String lastname;

    @ColumnInfo(name = "department")
    private String department;


    @NonNull
    @ColumnInfo(name = "room")
    private String room;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

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
    public String getRoom() {
        return room;
    }

    public void setRoom(@NonNull String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", nurseId=" + nurseId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", department='" + department + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
