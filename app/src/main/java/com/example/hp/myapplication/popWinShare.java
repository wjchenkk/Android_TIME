package com.example.hp.myapplication;

import android.widget.PopupWindow;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;


public class popWinShare extends PopupWindow {
    private View conentView;
    private Context context;
    public popWinShare(final Activity context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.daka, null);
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();
        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(w / 2 - 100);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
        // 实例化一个ColorDrawable
        ColorDrawable dw = new ColorDrawable(80);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);
        // mPopupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        //this.setAnimationStyle(R.style.AnimTools);
        LinearLayout getUpLayout = (LinearLayout) conentView
                .findViewById(R.id.get_up_layout);
        LinearLayout focusLayout = (LinearLayout) conentView
                .findViewById(R.id.focus_layout);
        LinearLayout sleepLayout = (LinearLayout) conentView
                .findViewById(R.id.sleep_layout);
        getUpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(context,"起床打卡成功！",Toast.LENGTH_SHORT).show();
                popWinShare.this.dismiss();
            }
        });

        focusLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context,"今日专注打卡成功！",Toast.LENGTH_SHORT).show();
                popWinShare.this.dismiss();
            }
        });
        sleepLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context,"睡眠打卡成功！",Toast.LENGTH_SHORT).show();
                popWinShare.this.dismiss();
            }
        });
    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {

        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent,500,10);

        } else {
            this.dismiss();
        }
    }

}

