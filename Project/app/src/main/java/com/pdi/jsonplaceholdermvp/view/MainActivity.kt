package com.pdi.jsonplaceholdermvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pdi.jsonplaceholdermvp.MainContract
import com.pdi.jsonplaceholdermvp.MainInteractor
import com.pdi.jsonplaceholdermvp.R
import com.pdi.jsonplaceholdermvp.model.local.MainRepository
import com.pdi.jsonplaceholdermvp.presenter.MainPresenter
import com.pdi.jsonplaceholdermvp.presenter.RecyclerPhotosAdapter

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainPresenter
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: RecyclerPhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, MainInteractor(MainRepository()))
    }

    override fun showListPhotos() {
        adapter = RecyclerPhotosAdapter(presenter.getPhotosFromInteractor())
        recycler.findViewById<RecyclerView>(R.id.recyclerView)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun showMessageError() {
        Toast.makeText(this, "Ops, não carregou os dados da API", Toast.LENGTH_LONG).show()
    }
}