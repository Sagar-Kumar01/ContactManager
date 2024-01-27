package com.example.contactmanager;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {
    Contact contact;
    Context context;
    MyViewModel myViewModel;

    public AddNewContactClickHandler(Contact contact, Context context, MyViewModel myViewModel) {
        this.contact = contact;
        this.context = context;
        this.myViewModel = myViewModel;
    }
    public void onSubmitBtnClicked(View view){
        if(contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context, "Fill Details First", Toast.LENGTH_SHORT).show();
        }else{
            Intent i = new Intent(context,MainActivity.class);
//            i.putExtra("Name",contact.getName());
//            i.putExtra("Email",contact.getEmail());
            Contact c = new Contact(
                    contact.getName(),
                    contact.getEmail()
            );
            myViewModel.addNewContact(c);
            context.startActivity(i);
        }
    }
}
