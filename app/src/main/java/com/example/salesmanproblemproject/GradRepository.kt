package com.example.salesmanproblemproject

import androidx.lifecycle.LiveData
import com.example.salesmanproblemproject.database.GradDB
import com.example.salesmanproblemproject.database.GradDBDao

class GradRepository(private val gradDao: GradDBDao) {


    val readAllData: LiveData<List<GradDB>> = gradDao.getAllCities()

    suspend fun addGrad(grad: GradDB) {
        gradDao.insert(grad)
    }

    suspend fun deleteAll() {
        gradDao.deleteAll()
    }

    suspend fun deleteCity(grad: GradDB) {
        gradDao.deleteCity(grad)
    }

    suspend fun dajSve():List<GradDB> {
        return gradDao.dajSve()
    }

}