package mine.leakcanary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import leakcanary.AppWatcher;
import leakcanary.LeakCanary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void start(View view) {
        System.out.println("~~start~~");

        startActivity(new Intent(this, OneActivity.class));
//        startActivity(new Intent(this, TwoActivity.class));
//        startService(new Intent(this, TheService.class));

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

    public void stop(View view) {
        System.out.println("~~stop~~");
//        System.out.println(OneActivity.context);

        stopService(new Intent(this, TheService.class));
    }


    public void go(View view) {
        System.out.println("~~go~~");
    }
}