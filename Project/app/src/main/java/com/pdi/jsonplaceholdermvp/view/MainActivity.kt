package com.pdi.jsonplaceholdermvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.pdi.jsonplaceholdermvp.utils.MainContract
import com.pdi.jsonplaceholdermvp.model.local.MainInteractor
import com.pdi.jsonplaceholdermvp.R
import com.pdi.jsonplaceholdermvp.model.local.MainRepository
import com.pdi.jsonplaceholdermvp.model.local.Photo
import com.pdi.jsonplaceholdermvp.model.remote.network.Network
import com.pdi.jsonplaceholdermvp.model.remote.network.PhotoService
import com.pdi.jsonplaceholdermvp.presenter.MainPresenter
import com.pdi.jsonplaceholdermvp.presenter.RecyclerPhotosAdapter
import com.pdi.jsonplaceholdermvp.utils.Constants
import com.pdi.jsonplaceholdermvp.utils.ManageThreads
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var interactor: MainContract.Interactor
    private lateinit var repository: MainContract.Repository
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        initRequest()
    }

    private fun initRequest() {
        repository = MainRepository(Network.provideService(PhotoService::class.java))
        interactor = MainInteractor(repository)
        presenter = MainPresenter(this, interactor, ManageThreads(AndroidSchedulers.mainThread(), Schedulers.io()))

        presenter.getPhotosFromInteractor()
    }

    private fun initRecyclerView() {
        recycler = findViewById(R.id.recyclerView)
        recycler.adapter = RecyclerPhotosAdapter()
    }

    override fun showListPhotos(list: List<Photo>) {
        (recycler.adapter as RecyclerPhotosAdapter).updatePhotos(list)
    }

    override fun showMessageError() {
        Toast.makeText(this, Constants.ERROR_API, Toast.LENGTH_LONG).show()
    }

    override fun willDestroyCompositeDisposable() {
        presenter.destroyCompositeDisposable()
    }
}