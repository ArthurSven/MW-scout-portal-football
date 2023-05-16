package com.example.mwyouthfootballportal.Data.DB

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseDatabaseManager {
    private var database: DatabaseReference? = null

    fun getFireBaseDB(): DatabaseReference {
        if(database == null) {
            database = FirebaseDatabase.getInstance().reference
        }
        return database!!
    }
}