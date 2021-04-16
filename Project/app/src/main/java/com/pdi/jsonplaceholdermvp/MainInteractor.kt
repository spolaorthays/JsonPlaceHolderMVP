package com.pdi.jsonplaceholdermvp

import com.pdi.jsonplaceholdermvp.model.local.MainRepository
import com.pdi.jsonplaceholdermvp.model.local.Photo

class MainInteractor(private var repository: MainRepository) : MainContract.Interactor {

    override fun getPhotosFromRepository(): List<Photo> {
        return repository.getPhotos()
    }
}