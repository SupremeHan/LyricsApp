package android.singidunum.ac.rs.ispitrma.application

import android.app.Application
import android.singidunum.ac.rs.ispitrma.modules.coreModule
import android.singidunum.ac.rs.ispitrma.modules.favouritesModule
import android.singidunum.ac.rs.ispitrma.modules.lyricsModule
import android.singidunum.ac.rs.ispitrma.modules.trackChartModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class IspitRMAApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init(){
        initTimber()
        initKoin()
        initStetho()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val modules = listOf(
            coreModule,
            trackChartModule,
            lyricsModule,
            favouritesModule
        )
        startKoin {
            androidLogger(Level.DEBUG)

            androidContext(this@IspitRMAApplication)

            androidFileProperties()

            fragmentFactory()

            modules(modules)
        }
    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(this)
    }
}