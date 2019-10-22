package com.happy.krutarthassignment.network

import com.happy.krutarthassignment.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface NetworkInterface {

    @GET("users")
    fun getUsers() : Call<List<ResponseModel>>

}