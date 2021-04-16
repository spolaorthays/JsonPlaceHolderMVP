package com.pdi.jsonplaceholdermvp

import com.pdi.jsonplaceholdermvp.model.local.Photo

interface MainContract {

    interface View {
        fun showListPhotos()
        fun showMessageError()
    }

    interface Presenter {
        fun getPhotosFromInteractor(): List<Photo>
        fun resultGetPhotos()
    }

    interface Interactor {
        fun getPhotosFromRepository(): List<Photo>
    }

    interface Repository {
        fun getPhotos(): List<Photo>
    }

}