package mine.leakcanary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import curtains.Curtains;
import curtains.OnRootViewAddedListener;

public class OneActivity extends AppCompatActivity {
//    public static Context context;

    private String s = "99";
    private int n = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

//        getWindow().getDecorView().addOnAttachStateChangeListener(new AttachStateChangeLinstener());


        //测试根View泄漏（测试失败了）
//        Curtains.getOnRootViewsChangedListeners().add(new OnRootViewAddedListener() {
//            @Override
//            public void onRootViewAdded(@NonNull View view) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onRootViewAdded~~");
//                System.out.println("view = " + view);
//            }
//
//            @Override
//            public void onRootViewsChanged(@NonNull View view, boolean b) {
//                System.out.println("~~" + getClass().getSimpleName() + ".onRootViewsChanged~~");
//                System.out.println("view = " + view + ", b = " + b);
//
//            }
//        });


//        ((TheApplication) getApplication()).getCList().add(n);
//        ((TheApplication) getApplication()).getSList().add(s);


//        ((TheApplication) getApplication()).hList.get("d");

//        getWindow().getDecorView().getViewTreeObserver().addOnPreDrawListener();


    }


    public void start(View view) {
        System.out.println("~~one.start~~");
        //保存View导致泄漏
//        saveView();

        //使用线程导致泄漏
//        thread(view);


        //使用静态变量导致泄漏
//        context = this;

        //引用View
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.cl, new OneFragment(), "one");
//        fragmentTransaction.addToBackStack("one");
//        fragmentTransaction.commit();


        //引用根View
        startDialog();
//        startToast();//测试Toast失败了，不会检测泄漏
//        view.setTooltipText("XX");//测试TooltipText失败了，不会检测泄漏
    }


    public void stop(View view) {
        System.out.println("~~stop~~");
        startDialog();
    }

    @Override
    protected void onPause() {
        System.out.println("~~" + getClass().getSimpleName() + ".onPause~~");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("~~" + getClass().getSimpleName() + ".onStop~~");
        super.onStop();
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
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int n = 0;
//                while (true) {
//
////                    System.out.println(n + "|go|" + v);
//                    System.out.println(n + "|go|");
//                    try {
//                        Thread.sleep(1000L);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    if (n++ > 100) break;
//                }
//            }
//        }).start();

        new Thread(new TheRunnable()).start();

    }

    static class TheRunnable implements Runnable {

        @Override
        public void run() {
            int n = 0;
            while (true) {

//                    System.out.println(n + "|go|" + v);
                System.out.println(n + "|go|");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (n++ > 100) break;
            }
        }
    }


    private void startToast() {
        Toast toast = Toast.makeText(this, "xxx", Toast.LENGTH_SHORT);


        toast.show();

    }
    private void startDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.out.println("~~positive~~");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        System.out.println("id is " + id);
                        System.out.println("~~negative~~");
                        dialog.cancel();
                    }
                })
                .show();

        TheApplication.getVDialog().add(alertDialog);

    }

}