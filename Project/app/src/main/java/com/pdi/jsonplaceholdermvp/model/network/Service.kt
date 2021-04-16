package com.pdi.jsonplaceholdermvp.model.network

import com.pdi.jsonplaceholdermvp.model.local.Photo
import retrofit2.Call
import retrofit2.http.GET

interface Service {

    @GET("/photos")
    fun getPhotos(): Call<List<Photo>>

}