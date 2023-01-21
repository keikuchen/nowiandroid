package keikuchen.nowiandroid

import android.app.Application
import timber.log.Timber

class NowiApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(NowiDebugTree())
    }
}
