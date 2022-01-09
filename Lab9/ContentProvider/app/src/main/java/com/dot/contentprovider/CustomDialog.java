package com.dot.contentprovider;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;


public  class CustomDialog extends AppCompatDialogFragment
{
    TextView txt;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view =  inflater.inflate(R.layout.dialog,null);
        txt = view.findViewById(R.id.textView);
        txt.setText(getArguments().getString("description"));
        builder.setView(view).setTitle("Word Details ").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        return builder.create();


//        return super.onCreateDialog(savedInstanceState);

    }

}