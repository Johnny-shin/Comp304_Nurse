package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.NurseDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Nurse.class, Patient.class}, version = 1, exportSchema = false)
public abstract class NurseRoomDatabase extends RoomDatabase{
    private static final String DATABASE = "Nurse";
    private static NurseRoomDatabase instance;



        static NurseRoomDatabase getDatabase(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NurseRoomDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
    public abstract NurseDao getNurseDao();
}



//
//@Database(entities = {Nurse.class}, version = 1, exportSchema = false)
//public abstract class NurseRoomDatabase extends RoomDatabase {
//
//    abstract NurseDao nurseDao();
//
//    private static volatile NurseRoomDatabase INSTANCE;
//    private static final int NUMBER_OF_THREADS = 4;
//
//    static final ExecutorService databaseWriteExecutor =
//            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
//
//    static NurseRoomDatabase getDatabase(final Context context){
//        if(INSTANCE == null){
//            synchronized (NurseRoomDatabase.class){
//                if(INSTANCE == null){
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            NurseRoomDatabase.class, "nurse_table").build();
//                }
//            }
//        }
//
//        return INSTANCE;
//    }
//
//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onOpen(@NonNull SupportSQLiteDatabase db) {
//            super.onOpen(db);
//
//            // If you want to keep data through app restarts,
//            // comment out the following block
//            databaseWriteExecutor.execute(() -> {
//                // Populate the database in the background.
//                // If you want to start with more words, just add them.
//                NurseDao dao = INSTANCE.nurseDao();
//
//                dao.deleteAllNurse();//Clear data
//
////                Default dataset
////                @NonNull int nurseId, @NonNull String firstname, @NonNull String lastname, String department, @NonNull String password
//                Nurse nurse = new Nurse(100, "Hyunjong", "Shin", "Emergency", "123");
//                dao.insertNurse(nurse);
//                nurse = new Nurse(101, "Johnny", "Shin", "Emergency", "123");
//                dao.insertNurse(nurse);
//
//            });
//        }
//    };
//}
