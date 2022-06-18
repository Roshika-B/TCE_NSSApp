package com.roshh.tcenssapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOVolunteer {
    private DatabaseReference dbref;
    public DAOVolunteer(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbref=db.getReference(Volunteer.class.getSimpleName());
    }
    public Task<Void> add(Volunteer vol){
        return dbref.push().setValue(vol);
    }
}
