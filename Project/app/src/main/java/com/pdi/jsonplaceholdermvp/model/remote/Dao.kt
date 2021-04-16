package com.pdi.jsonplaceholdermvp.model.remote

import android.util.Log
import com.pdi.jsonplaceholdermvp.model.local.Photo
import com.pdi.jsonplaceholdermvp.model.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Dao {

    fun getPhotos(): List<Photo> {
        var list = mutableListOf<Photo>()
        val call: Call<List<Photo>>? = Retrofit.getPhotosFromService()?.getPhotos()
        call?.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.body() != null) {
                    response.body()?.forEach { photo ->
                        list.add(photo)
                    }
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                t.message?.let { Log.d("Error request", it) }
            }

        })
        return list
    }

}