package com.happy.krutarthassignment.viewmodels

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.repository.Repository

class SharedViewModel : ViewModel() {

    lateinit var snippet : (response : ResponseModel) -> Unit

    fun initCacheFromServer(context: Context)
    {
       Repository.saveAllUsersFromNetwork(context)
    }

    fun getAllUsersFromCache(context: Context) : LiveData<List<ResponseModel>>
    {
        return Repository.getAllUsersFromCache(context)
    }

    fun deleteUser(context: Context,user : ResponseModel)
    {
        Repository.deletSingleUser(context,user)
    }

    fun addUser(context: Context,user: ResponseModel)
    {
        Repository.insertSingleUser(context,user)
    }

    fun toggleFavourite(context: Context,user: ResponseModel)
    {
        user.favourite = !user.favourite

        Repository.insertSingleUser(context,user)
    }


}