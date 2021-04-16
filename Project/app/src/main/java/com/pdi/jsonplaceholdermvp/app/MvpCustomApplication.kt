package com.pdi.jsonplaceholdermvp.app

import android.app.Application
import com.pdi.jsonplaceholdermvp.model.remote.network.Network

class MvpCustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Network.initialize(baseContext)
    }
}