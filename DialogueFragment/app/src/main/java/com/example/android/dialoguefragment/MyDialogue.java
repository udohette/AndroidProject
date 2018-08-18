package com.example.android.dialoguefragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by DENNIS on 12/9/2016.
 */
public class MyDialogue extends DialogFragment implements View.OnClickListener{
    Button Yes,No;
    Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.my_dialogue,null);
        Yes = (Button)view.findViewById(R.id.button);
        No = (Button)view.findViewById(R.id.button2);
        Yes.setOnClickListener(this);
        No.setOnClickListener(this);
        setCancelable(false);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            dismiss();
            communicator.onDialogMessage("yes Button  was clicked");
        }else {
            dismiss();
            communicator.onDialogMessage("No Button was click");
        }
    }
    interface Communicator{
        public void onDialogMessage(String Message);

    }
}
