package com.roshh.tcenssapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOPatientDetail {
    private DatabaseReference dbref;
    public DAOPatientDetail(){
        FirebaseDatabase patientdb=FirebaseDatabase.getInstance();
        dbref=patientdb.getReference(PatientDetail.class.getSimpleName());
    }
    public Task<Void> add(PatientDetail pat){
        return dbref.push().setValue(pat);
    }
}
