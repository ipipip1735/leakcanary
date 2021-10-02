package mine.leakcanary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Random;

public class OneFragment extends Fragment {
    public Inner inner = new Inner();
    public Nest nest = new Nest();
    public TheViewModel theViewModel;


    @Override
    public void onAttach(Context context) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onAttach  *********");
        super.onAttach(context);

        System.out.println(context);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreate  *********");

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onCreateView  *********");

        View view = inflater.inflate(R.layout.fragment_one, container, false);
        System.out.println("view = " + view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        System.out.println("*********  " + getClass().getSimpleName() + ".onViewCreated  *********");
        super.onViewCreated(view, savedInstanceState);


//        inner.fragment = this;
//        inner.view = view;

//        nest.fragment = this;
//        nest.view = view;

    }

    @Override
    public void onStart() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onStart  *********");
        super.onStart();

    }

    @Override
    public void onResume() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onResume  *********");
        super.onResume();

    }

    @Override
    public void onPause() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onPause  *********");
        super.onPause();

    }

    @Override
    public void onStop() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onStop  *********");
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("*********  " + getClass().getSimpleName() + ".onDestroyView  *********");
//        inner.thread();
//        nest.thread();

//        Helper.dialog(getContext());
//        Helper.update(getView().findViewById(R.id.textView));


        theViewModel = new ViewModelProvider(this).get(TheViewModel.class);
//        theViewModel.setView(getView());
        theViewModel.doWork();


    }

    @Override
    public void onDestroy() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onDestroy  *********");
        super.onDestroy();

    }

    @Override
    public void onDetach() {
        System.out.println("*********  " + getClass().getSimpleName() + ".onDetach  *********");
        super.onDetach();

    }


    class Inner{
        private Fragment fragment;
        private View view;

        private void  thread() {
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

                        if (n++ > 100) break;
                    }
                }
            }).start();
        }


    }


    static class Nest{
        private Fragment fragment;
        private View view;

        private void  thread() {
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

                        if (n++ > 100) break;
                    }
                }
            }).start();
        }

    }



}
