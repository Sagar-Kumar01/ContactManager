package com.example.contactmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class},version = 1)
public abstract class ContactDataBase extends RoomDatabase {
    public abstract contactDAO getContactDAO();

    private static ContactDataBase dbInstance;
    public static synchronized ContactDataBase getInstance(Context context){
        if(dbInstance == null){
            dbInstance = Room.databaseBuilder(context.getApplicationContext(),ContactDataBase.class,"contact_db")
                    .fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    }
}
