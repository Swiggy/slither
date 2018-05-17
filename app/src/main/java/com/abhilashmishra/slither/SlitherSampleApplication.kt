package com.abhilashmishra.slither

import android.app.Application
import com.facebook.soloader.SoLoader

class SlitherSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false);
    }
}