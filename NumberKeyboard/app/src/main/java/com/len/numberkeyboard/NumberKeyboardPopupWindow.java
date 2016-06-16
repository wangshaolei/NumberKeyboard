package com.len.numberkeyboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Shaolei on 2016/6/14.
 */
public class NumberKeyboardPopupWindow {
    @BindView(R.id.ll_close)
    LinearLayout llClose;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn0)
    Button btn0;
    @BindView(R.id.btn_check)
    Button btnCheck;

    private static Context mContext;
    private static NumberKeyboardPopupWindow mPopupWindow;
    private String number = "";
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
                number = "1";
                listener.insertStr(number);
                break;
            case R.id.btn2:
                number = "2";
                listener.insertStr(number);
                break;
            case R.id.btn3:
                number = "3";
                listener.insertStr(number);
                break;
            case R.id.btn4:
                number = "4";
                listener.insertStr(number);
                break;
            case R.id.btn5:
                number = "5";
                listener.insertStr(number);
                break;
            case R.id.btn6:
                number = "6";
                listener.insertStr(number);
                break;
            case R.id.btn7:
                number = "7";
                listener.insertStr(number);
                break;
            case R.id.btn8:
                number = "8";
                listener.insertStr(number);
                break;
            case R.id.btn9:
                number = "9";
                listener.insertStr(number);
                break;
            case R.id.btn0:
                number = "0";
                listener.insertStr(number);
                break;
            case R.id.btn_check:
                listener.check();
                break;
        }
    }
}
