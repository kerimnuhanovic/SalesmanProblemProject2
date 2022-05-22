package com.example.salesmanproblemproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.salesmanproblemproject.Grad

@Dao
interface GradDBDao {

    @Insert
    fun insert(grad: GradDB)

    @Query("select * from grad_table where id = :key")
    fun get(key: Long):GradDB

    @Query("delete from grad_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteCity(grad: GradDB)

    @Query("select * from grad_table")
    fun getAllCities() : LiveData<List<GradDB>>

    @Query("select * from grad_table")
    fun dajSve() : List<GradDB>

}