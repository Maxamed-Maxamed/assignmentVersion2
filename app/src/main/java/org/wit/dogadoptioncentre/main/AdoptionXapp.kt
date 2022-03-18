package org.wit.dogadoptioncentre.main

import android.app.Application
import org.wit.dogadoptioncentre.models.AdoptionMemStore
import org.wit.dogadoptioncentre.models.AdoptionStore
import timber.log.Timber

class AdoptionXApp : Application() {

    lateinit var adoptionStore: AdoptionStore
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        adoptionStore = AdoptionMemStore()
        Timber.i("Starting AdoptionX Application")
    }


}