package mine.leakcanary

import android.app.ProgressDialog
import android.content.Context
import android.view.View
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2021/9/28.
 */
object Helper {


    @JvmStatic
    fun dialog(context: Context) {
        println("context = [${context}]")
        ProgressDialog(context).show()
    }

    @JvmStatic
    fun update(view: View) {

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
}