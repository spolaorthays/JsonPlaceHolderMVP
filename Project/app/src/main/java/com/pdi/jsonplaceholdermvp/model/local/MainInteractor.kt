package com.pdi.jsonplaceholdermvp.model.local

import com.pdi.jsonplaceholdermvp.utils.MainContract
import io.reactivex.Single

class MainInteractor(private val repository: MainContract.Repository) : MainContract.Interactor {

    override fun getPhotosFromRepository(): Single<List<Photo>> {
        return repository.getPhotosFromService()
    }
}