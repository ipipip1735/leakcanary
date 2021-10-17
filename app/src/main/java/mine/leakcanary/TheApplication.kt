package mine.leakcanary

import android.app.Application
import android.app.Dialog
import android.view.View
import curtains.Curtains
import curtains.OnRootViewsChangedListener
import leakcanary.AppWatcher
import leakcanary.LeakCanary
import leakcanary.RootViewWatcher

/**
 * Created by Administrator on 2021/9/27.
 */
class TheApplication : Application() {

    val list = mutableListOf<View>()
    companion object{
        @JvmStatic val cList = mutableListOf<Int>()
        @JvmStatic val sList = mutableListOf<String>()
        @JvmStatic val vList = mutableListOf<View>()
        @JvmStatic val vDialog = mutableListOf<Dialog>()
        @JvmField val hList = hashMapOf<String, Int>()
    }

    override fun onCreate() {
        super.onCreate()
        println("~~TheApplication.onCreate~~")

        val list = AppWatcher.appDefaultWatchers(this)
            .filter {
                println("it = ${it}")
                it is RootViewWatcher
//                true
            }

        AppWatcher.manualInstall(this, watchersToInstall = list)
        LeakCanary.config = LeakCanary.config.copy(retainedVisibleThreshold = 1)


    }
}