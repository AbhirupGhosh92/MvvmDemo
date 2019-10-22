package com.happy.krutarthassignment.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    companion object{

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private var retroFit: Retrofit? = null
        val instance:Retrofit
        get()  {
            if (retroFit == null) {
                val httpClient = OkHttpClient.Builder()
                retroFit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()
            }

            return retroFit!!
        }

    }

}