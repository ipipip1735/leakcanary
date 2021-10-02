package mine.leakcanary;

import android.view.View;

/**
 * Created by Administrator on 2021/10/1.
 */
public class AttachStateChangeLinstener implements View.OnAttachStateChangeListener {
    @Override
    public void onViewAttachedToWindow(View v) {
        System.out.println("~~" + getClass().getSimpleName() + ".onViewAttachedToWindow~~");
        System.out.println("v = " + v);
    }

    @Override
    public void onViewDetachedFromWindow(View v) {
        System.out.println("~~" + getClass().getSimpleName() + ".onViewDetachedFromWindow~~");
        System.out.println("v = " + v);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int n = 0;
                while (true) {

                    System.out.println(n + "|go|" + v);
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (n++ > 100) break;
                }
            }
        }).start();


    }
}
