package com.pdi.jsonplaceholdermvp.presenter

import com.pdi.jsonplaceholdermvp.utils.MainContract
import com.pdi.jsonplaceholdermvp.utils.ManageThreads
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class MainPresenter(
    private val view: MainContract.View,
    private val interactor: MainContract.Interactor,
    private val scheduler: ManageThreads
) : MainContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getPhotosFromInteractor() {
        compositeDisposable += interactor.getPhotosFromRepository()
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.main)
            .subscribeBy(
                onError = { view.showMessageError() },
                onSuccess = view::showListPhotos
            )
    }

    override fun destroyCompositeDisposable() {
        compositeDisposable.dispose()
    }

}