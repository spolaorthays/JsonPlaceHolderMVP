package com.pdi.jsonplaceholdermvp.presenter

import com.pdi.jsonplaceholdermvp.utils.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    private val view: MainContract.View,
    private val interactor: MainContract.Interactor
) : MainContract.Presenter { //TODO Passar os schedulers como parametros

    private val compositeDisposable = CompositeDisposable()

    override fun getPhotosFromInteractor() {
        compositeDisposable += interactor.getPhotosFromRepository()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = { view.showMessageError() },
                onSuccess = view::showListPhotos
            )
    }

    override fun destroyCompositeDisposable() {
        compositeDisposable.dispose()
    }

}