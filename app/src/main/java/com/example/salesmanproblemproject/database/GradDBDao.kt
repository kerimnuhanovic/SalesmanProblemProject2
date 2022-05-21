package com.example.salesmanproblemproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GradDBDao {

    @Insert
    fun insert(grad: GradDB)

    @Query("select * from grad_table where id = :key")
    fun get(key: Long):GradDB

    @Query("delete from grad_table")
    fun clear()

    @Query("select * from grad_table")
    fun getAllCities() : LiveData<List<GradDB>>
}