package com.example.hp.myapplication.layout;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.myapplication.R;

public class TitleLayout extends LinearLayout {
    public TitleLayout (final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

        if (context.getClass().getSimpleName().equals("TeamsListActivity")) {
            ImageButton btn_create = findViewById(R.id.btn_create);
            btn_create.setVisibility(VISIBLE);

            btn_create.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });
        }
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    private void showDialog() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_create_team, null);
        final AlertDialog dialog = new AlertDialog.Builder(getContext()).setView(view).create();

        ImageButton btn_close = view.findViewById(R.id.dialog_btn_close);
        final TextView create = view.findViewById(R.id.dialog_selection_create_team);
        final TextView join = view.findViewById(R.id.dialog_selection_join_team);
        Button btn_confirm =  view.findViewById(R.id.dialog_btn_confirm);
        Button btn_cancel = view.findViewById(R.id.dialog_btn_cancel);

        create.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                create.setBackgroundResource(R.drawable.textview);
                join.setBackgroundResource(R.drawable.textview2);
                create.setClickable(false);
                join.setClickable(true);
            }
        });
        create.setClickable(false);
        join.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                create.setBackgroundResource(R.drawable.textview2);
                join.setBackgroundResource(R.drawable.textview);
                create.setClickable(true);
                join.setClickable(false);
            }
        });

        btn_close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_confirm.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.setCancelable(false);
    }
}
