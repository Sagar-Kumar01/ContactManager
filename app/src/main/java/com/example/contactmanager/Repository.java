package com.example.contactmanager;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.LogRecord;

public class Repository {

    private final contactDAO contactdao;
    ExecutorService executer;
    Handler handler;

    public Repository(Application application) {

        ContactDataBase contactDataBase = ContactDataBase.getInstance(application);
        this.contactdao = contactDataBase.getContactDAO();
        executer = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
    }
    public void addContact(Contact contact){



        executer.execute(new Runnable() {
            @Override
            public void run() {
                contactdao.insert(contact);
            }
        });

    }

    public void deleteContact(Contact contact){
        executer.execute(new Runnable() {
            @Override
            public void run() {
                contactdao.delete(contact);
            }
        });

    }

    public LiveData<List<Contact>> getAllContact(){
        return contactdao.getAllcontact();
    }
}
