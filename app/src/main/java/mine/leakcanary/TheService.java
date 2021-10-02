package mine.leakcanary;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * Created by Administrator on 2021/9/30.
 */
public class TheService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        System.out.println("---- " + getClass().getSimpleName() + ".onCreate ----");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("---- " + getClass().getSimpleName() + ".onStartCommand ----");

//        System.out.println("start id  is " + startId);
//        Message message = Message.obtain();
//        message.what = startId;
//        serviceHandler.sendMessage(message);

        return START_STICKY;
    }


    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("---- " + getClass().getSimpleName() + ".onUnbind ----");
        return super.onUnbind(intent);
    }


    @Override
    public void onRebind(Intent intent) {
        System.out.println("---- " + getClass().getSimpleName() + ".onRebind ----");
        super.onRebind(intent);
    }


    @Override
    public void onDestroy() {
        System.out.println("---- " + getClass().getSimpleName() + ".onDestroy ----");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                while (true) {

                    System.out.println(n + "|go!");
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(n++ > 100)break;

                }
            }
        }).start();

    }

}
