package com.example.contactmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.contactmanager.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ContactDataBase contactDataBase;
    ArrayList<Contact> contactArrayList = new ArrayList<>();

    Myadapter adapter;

    ActivityMainBinding binding;
    MainActivityClickHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        handler = new MainActivityClickHandler(this);

        binding.setClickHandler(handler);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        contactDataBase = contactDataBase.getInstance(this);

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);


       viewModel.getAllcontact().observe(this, new Observer<List<Contact>>() {
           @Override
           public void onChanged(List<Contact> contacts) {
               contactArrayList.clear();
               for(Contact c: contacts){

                   contactArrayList.add(c);
               }
               adapter.notifyDataSetChanged();
           }
       });
        adapter = new Myadapter(contactArrayList);

       recyclerView.setAdapter(adapter);

       new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
           @Override
           public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
               return false;
           }

           @Override
           public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

               Contact c = contactArrayList.get(viewHolder.getAdapterPosition());
               viewModel.deleteContact(c);
           }
       }).attachToRecyclerView(recyclerView);



    }
}