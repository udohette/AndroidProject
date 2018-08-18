package com.example.android.asyntask2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DENNIS on 2/21/2017.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class NonUITaskFragment extends Fragment {
    MyTask myTask;
    private Context context;
    public NonUITaskFragment(){

    }
    public void beginTask(String... arguments){
        myTask = new MyTask(context);
        myTask.execute(arguments);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if(myTask !=null){
            myTask.onAttach(context);
        }
        L.m("Fragment on Attach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        L.m("Fragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        L.m("Fragment onCreateView");
        return null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        L.m("fragment onActivityCreated");
        setRetainInstance(true);
    }

    @Override
    public void onStart() {
        super.onStart();
        L.m("Fragment onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        L.m("Fragment onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        L.m("Fragment onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        L.m("fragment onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        L.m("Fragment onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        L.m("Fragment onViewStateRestored");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.m("Fragment onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.m("Fragment onDestroy");
    }

    @Override
    public void onDetach() {
        if (myTask != null){
            myTask.onDetach();
        }
        super.onDetach();
        L.m("Fragment onDetach");
    }
}
