package com.example.contactmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private Repository myrepository;
    private LiveData<List<Contact>> allcontact;
    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myrepository= new Repository(application);
    }
    public LiveData<List<Contact>> getAllcontact(){
        allcontact = myrepository.getAllContact();
        return allcontact;
    }
    public void addNewContact(Contact contact){
        myrepository.addContact(contact);
    }
    public void deleteContact(Contact contact){
        myrepository.deleteContact(contact);
    }
}
