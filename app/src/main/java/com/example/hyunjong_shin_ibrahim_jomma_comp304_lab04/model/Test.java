package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "test_table")
public class Test {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "testId")
    private int testId;

    @NonNull
    @ColumnInfo(name = "patientId")
    private int patientId;

    @NonNull
    @ColumnInfo(name = "nurseId")
    private int nurseId;

    @ColumnInfo(name = "BPL")
    private String BPL;

    @ColumnInfo(name = "BPH")
    private String BPH;

    @ColumnInfo(name = "temperature")
    private double temperature;







}
