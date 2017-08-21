package com.len.numberkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shaolei on 2016/6/14.
 */
public class NumberKeyboardPopupWindow {
    
    private static Context mContext;
    private static NumberKeyboardPopupWindow mPopupWindow;
    private NumberKeyboardUtil.OnPopuWindowListener listener;

    public NumberKeyboardPopupWindow() {
    }

    public static NumberKeyboardPopupWindow getInstance(Context context) {
        mContext = context;

        if (mPopupWindow == null) {
            mPopupWindow = new NumberKeyboardPopupWindow();
        }
        return mPopupWindow;
    }

    public PopupWindow onCreate(NumberKeyboardUtil.OnPopuWindowListener listener) {
        this.listener = listener;
        View popupView = LayoutInflater.from(mContext).inflate(R.layout.layout_number_keyboard, null);
        ButterKnife.bind(this, popupView);
        PopupWindow keyboardPopupwindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, false);
        keyboardPopupwindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        keyboardPopupwindow.setFocusable(false);
        keyboardPopupwindow.setOutsideTouchable(false);
        return keyboardPopupwindow;
    }


    @OnClick({R.id.ll_close, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn0, R.id.btn_check})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_close:
                listener.dismiss();
                break;
            case R.id.btn1:       
                listener.insertStr("1");
                break;
            case R.id.btn2:
                listener.insertStr("2");
                break;
            case R.id.btn3:
                listener.insertStr("3");
                break;
            case R.id.btn4:
                listener.insertStr("4");
                break;
            case R.id.btn5:
                listener.insertStr("5");
                break;
            case R.id.btn6:
                listener.insertStr("6");
                break;
            case R.id.btn7:
                listener.insertStr("7");
                break;
            case R.id.btn8:
                listener.insertStr("8");
                break;
            case R.id.btn9:
                listener.insertStr("9");
                break;
            case R.id.btn0:
                listener.insertStr("0");
                break;
            case R.id.btn_check:
                listener.check();
                break;
        }
    }
}
