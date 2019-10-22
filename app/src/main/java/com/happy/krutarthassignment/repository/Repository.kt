package com.happy.krutarthassignment.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.happy.krutarthassignment.models.ResponseModel
import com.happy.krutarthassignment.network.NetworkClient
import com.happy.krutarthassignment.network.NetworkInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

object Repository {

    private var networkClient : NetworkInterface? = null

    init {
        if(networkClient == null)
            networkClient = NetworkClient.instance.create(NetworkInterface::class.java)
    }

    fun saveAllUsersFromNetwork(context: Context)
    {
        networkClient?.getUsers()?.enqueue(object : retrofit2.Callback<List<ResponseModel>>{
            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                try {
                    if (response.body() != null)
                        GlobalScope.launch(Dispatchers.IO) {
                            try {
                                AppDatabase.getInstance(context).userDao()
                                    .insertUsers(response.body()!!)
                            }catch (e : Exception)
                            {
                                e.printStackTrace()
                            }
                        }
                }
                catch (e : Exception)
                {
                    e.printStackTrace()
                }
            }

        })
    }

    fun getAllUsersFromCache(context: Context) : LiveData<List<ResponseModel>>
    {
        return AppDatabase.getInstance(context).userDao().getAllUsers()
    }

    fun deletSingleUser(context: Context,responseModel: ResponseModel)
    {

        GlobalScope.launch(Dispatchers.IO) {
            try {
                AppDatabase.getInstance(context).userDao().deleteUser(responseModel)
            }
            catch (e : Exception)
            {
                e.printStackTrace()
            }
        }
    }

    fun insertSingleUser(context: Context,responseModel: ResponseModel)
    {

        GlobalScope.launch(Dispatchers.IO) {
            try {
                AppDatabase.getInstance(context).userDao().insertUser(responseModel)
            }
            catch (e : Exception)
            {
                e.printStackTrace()
            }
        }
    }


}