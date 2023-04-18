package com.example.mwyouthfootballportal.Data.Models

import android.widget.ImageView
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class Team(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "teamID") val teamID: Int = 0,
    @ColumnInfo(name = "teamName") val teamName: String,
    @ColumnInfo(name = "teamLogo") val teamLogo: String,
    @ColumnInfo(name = "teamEmail") val teamEmail: String,
    @ColumnInfo(name = "teamNumber") val teamNumber: Int,
    @ColumnInfo(name = "password") val password: String,
)
