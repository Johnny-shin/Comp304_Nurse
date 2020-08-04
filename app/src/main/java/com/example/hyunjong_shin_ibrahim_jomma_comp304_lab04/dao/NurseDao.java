package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;

import java.util.List;

@Dao
public interface NurseDao {
    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.

    @Query("SELECT * FROM nurse_table")
    LiveData<List<Nurse>> getAllNurse();

    @Query("SELECT * FROM nurse_table")
    List<Nurse> getSavedUsersLists();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertNurse(Nurse nurse);


    @Query("DELETE FROM nurse_table")
    void deleteAllNurse();


    @Query("SELECT * FROM nurse_table WHERE nurseId = :nurseId LIMIT 1")
    Nurse findOneNurseName(int nurseId);


}

