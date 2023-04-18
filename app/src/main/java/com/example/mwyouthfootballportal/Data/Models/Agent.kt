package com.example.mwyouthfootballportal.Data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "agents")
data class Agent(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "agentID") val agentID: Int = 0,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "dob") val dob: Date,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
    )
