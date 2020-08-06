package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "test_table")
public class Test {
    public Test(@NonNull int patientId, @NonNull int nurseId, @NonNull String testName, @NonNull String test_description, @NonNull double temperature) {
        this.testId = testId;
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.testName = testName;
        this.test_description = test_description;
        this.temperature = temperature;
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "testId")
    private int testId;

    @NonNull
    @ColumnInfo(name = "patientId")
    private int patientId;

    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "test_name")
    private String testName;

    @ColumnInfo(name = "test_description")
    private String test_description;

    @ColumnInfo(name = "temperature")
    private double temperature;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTest_description() {
        return test_description;
    }

    public void setTest_description(String test_description) {
        this.test_description = test_description;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "testName   : " + testName + '\n' +
                "Description: " + test_description;
    }
}
