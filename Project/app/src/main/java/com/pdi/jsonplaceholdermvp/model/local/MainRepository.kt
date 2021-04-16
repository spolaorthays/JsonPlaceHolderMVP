package com.pdi.jsonplaceholdermvp.model.local

import com.pdi.jsonplaceholdermvp.utils.MainContract
import com.pdi.jsonplaceholdermvp.model.remote.network.PhotoService
import io.reactivex.Single

class MainRepository(private val service: PhotoService): MainContract.Repository {

    override fun getPhotos(): Single<List<Photo>> {
        return service.getPhotos()
    }

}