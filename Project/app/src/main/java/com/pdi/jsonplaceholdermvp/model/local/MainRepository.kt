package com.pdi.jsonplaceholdermvp.model.local

import com.pdi.jsonplaceholdermvp.MainContract
import com.pdi.jsonplaceholdermvp.model.remote.Dao

class MainRepository: MainContract.Repository {

    override fun getPhotos(): List<Photo> {
        val dao = Dao()
        return dao.getPhotos()
    }

}