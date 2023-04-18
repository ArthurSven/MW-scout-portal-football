package com.example.mwyouthfootballportal.Data.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.io.FileDescriptor
import java.sql.Date
import java.util.jar.Attributes


data class Player(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "playerID") val playerID: Int = 0,
    @ColumnInfo(name = "picture") val picture: String,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "dob") val dob: Date,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "height") val height: Double,
    @ColumnInfo(name = "attributes") val attributes: String,
    @ColumnInfo(name = "playerDescription") val playerDescription: String,
    @ColumnInfo(name = "playerVideo") val playerVideo: String,
    @ColumnInfo(name = "addedBy") val addedBy: String
    )
