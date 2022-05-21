package com.example.salesmanproblemproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "grad_table")
data class GradDB(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @ColumnInfo(name = "grad")
    var grad: String,
    @ColumnInfo(name = "drzava")
    var drzava: String,
    @ColumnInfo(name = "opis")
    var opis: String,
    @ColumnInfo(name = "latituda")
    var latituda: Double,
    @ColumnInfo(name = "longituda")
    var longituda: Double)
