package wallee.tech.assignment

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import wallee.tech.assignment.di.initKoin

class WalleeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        initKoin(this)
    }
}
