package com.pdi.jsonplaceholdermvp.utils

import com.pdi.jsonplaceholdermvp.model.local.Photo
import io.reactivex.Single

interface MainContract {

    interface View {
        fun showListPhotos(list: List<Photo>)
        fun showMessageError()
        fun willDestroyCompositeDisposable()
    }

    interface Presenter {
        fun getPhotosFromInteractor()
        fun destroyCompositeDisposable()
    }

    interface Interactor {
        fun getPhotosFromRepository(): Single<List<Photo>>
    }

    interface Repository {
        fun getPhotos(): Single<List<Photo>>
    }

}