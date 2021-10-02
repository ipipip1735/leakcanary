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

//        startActivity(new Intent(this, OneActivity.class));
//        startService(new Intent(this, TheService.class));

        startDialog();


    }

    private void startDialog() {

        boolean[] booleans = {false, true, false, true};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder
//                .setCustomTitle("header")
//                .setMultiChoiceItems(R.array.dialogs, booleans,
//                        new DialogInterface.OnMultiChoiceClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                                System.out.println("dialog is " + dialog);
//                                System.out.println("which is " + which);
//                                System.out.println("isChecked is " + isChecked);
//                            }
//                        })
//                .setView(R.layout.dialog_bottom)
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
//                        finish();
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