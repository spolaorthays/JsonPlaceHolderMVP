package com.pdi.jsonplaceholdermvp.model.remote.network

import com.pdi.jsonplaceholdermvp.model.local.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun getPhotos(): Single<List<Photo>>

}