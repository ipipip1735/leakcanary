package mine.leakcanary;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import curtains.Curtains;
import curtains.OnRootViewAddedListener;

public class OneActivity extends AppCompatActivity {
//    public static Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

//        getWindow().getDecorView().addOnAttachStateChangeListener(new AttachStateChangeLinstener());


        Curtains.getOnRootViewsChangedListeners().add(new OnRootViewAddedListener() {
            @Override
            public void onRootViewAdded(@NonNull View view) {
                System.out.println("~~" + getClass().getSimpleName() + ".onRootViewAdded~~");
                System.out.println("view = " + view);
            }

            @Override
            public void onRootViewsChanged(@NonNull View view, boolean b) {
                System.out.println("~~" + getClass().getSimpleName() + ".onRootViewsChanged~~");
                System.out.println("view = " + view + ", b = " + b);
            }
        });

    }


    public void start(View view) {
        System.out.println("~~start~~");
        //保存View导致泄漏
//        saveView();

        //使用线程导致泄漏
//        thread();


        //使用静态变量导致泄漏
//        context = this;

        //引用View
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.cl, new OneFragment(), "one");
//        fragmentTransaction.addToBackStack("one");
//        fragmentTransaction.commit();


        //引用根View

    }


    public void stop(View view) {
        System.out.println("~~stop~~");

    }

    @Override
    protected void onDestroy() {
        System.out.println("~~" + getClass().getSimpleName() + ".onDestroy~~");
        super.onDestroy();
    }

    private void saveView() {
        ((TheApplication) getApplication()).getList().add(findViewById(R.id.button));
    }

    private void thread(View v) {
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