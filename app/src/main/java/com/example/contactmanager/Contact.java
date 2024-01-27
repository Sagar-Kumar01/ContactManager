package com.example.contactmanager;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "contact_name")
    String name;
    @ColumnInfo(name = "contact_email")
    String email;

    public Contact( String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Contact() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
