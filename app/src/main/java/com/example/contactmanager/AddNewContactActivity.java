package com.example.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.contactmanager.databinding.ActivityAddNewContactBinding;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding binding;
    private AddNewContactClickHandler handler;
    private Contact contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        contacts = new Contact();
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_add_new_contact

        );

        MyViewModel myViewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);
        handler = new AddNewContactClickHandler(
                contacts,
                this,
                myViewModel
        );
        binding.setContact(contacts);
        binding.setHandler(handler);
    }
}