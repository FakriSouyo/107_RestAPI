package com.example.apidatabase

import android.app.Application
import com.example.apidatabase.Repository.AppContainer
import com.example.apidatabase.Repository.KontakContainer

class KontakAplikasi:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}


