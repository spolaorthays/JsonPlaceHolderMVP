package com.pdi.jsonplaceholdermvp.model.network

import com.pdi.jsonplaceholdermvp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    private lateinit var retrofit: retrofit2.Retrofit

    fun getRetrofit(): retrofit2.Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.writeTimeout(30, TimeUnit.SECONDS)

        retrofit = retrofit2.Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

     fun getPhotosFromService(): Service? {
        return getRetrofit().create(Service::class.java)
    }

}