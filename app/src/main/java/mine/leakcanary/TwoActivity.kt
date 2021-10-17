package mine.leakcanary

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2021/10/5.
 */
class TwoActivity: AppCompatActivity(){
    var k:Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        println("~~TwoActivity.onCreate~~")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_one)
    }

    fun start(view: View) {
        println("~~TwoActivity.start~~")

        thread {
            var n = 0
            while (true) {
//                println("$n|go")
//                println("$n|go|$k")
                println("$n|go|$view")
                try {
                    Thread.sleep(1000L)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                if (n++ > 100) break
            }
        }

//        Thread(Runnable {
//            var n = 0
//            while (true) {
//                println("$n|go|")
//                try {
//                    Thread.sleep(1000L)
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//                if (n++ > 100) break
//            }
//        }).start()

    }

}