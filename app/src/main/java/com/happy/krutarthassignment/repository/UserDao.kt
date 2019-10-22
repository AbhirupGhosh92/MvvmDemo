package com.happy.krutarthassignment.repository

import androidx.lifecycle.LiveData
import androidx.room.*
import com.happy.krutarthassignment.models.ResponseModel

@Dao
interface UserDao {

    @Query("select * from ResponseModel")
    fun getAllUsers() : LiveData<List<ResponseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(responseModel :ResponseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(responseModels :List<ResponseModel>)

    @Delete
    fun deleteUser(responseModels: ResponseModel)

}