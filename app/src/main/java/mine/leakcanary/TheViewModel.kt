package mine.leakcanary

import android.view.View
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2021/9/27.
 */
class TheViewModel: ViewModel() {
    var view: View? = null


    fun doWork() {
        thread {
            var n: Int = 0
            while (true) {
                println("$n|go!")
                Thread.sleep(1000L)
                if (n++ > 100) break
            }

            println("view = ${view}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("~~TheViewModel.onCleared~~")
        println("view = ${view}")

    }
}