package com.pdi.jsonplaceholdermvp.presenter

import com.pdi.jsonplaceholdermvp.MainContract
import com.pdi.jsonplaceholdermvp.MainInteractor
import com.pdi.jsonplaceholdermvp.model.local.Photo

class MainPresenter(private val view: MainContract.View, private val interactor: MainInteractor) : MainContract.Presenter{

    override fun getPhotosFromInteractor(): List<Photo> =
        interactor.getPhotosFromRepository()

    override fun resultGetPhotos() {
        if (interactor.getPhotosFromRepository().isNullOrEmpty().not()) {
            view.showListPhotos()
        } else {
            view.showMessageError()
        }
    }

}