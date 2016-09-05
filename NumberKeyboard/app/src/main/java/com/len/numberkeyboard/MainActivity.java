package com.len.numberkeyboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberKeyboardUtil.OnPopuWindowListener{

    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.input_layout)
    LinearLayout inputLayout;

    EditText etCode;
    private PopupWindow keyboardPopupwindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @OnClick({R.id.ll_top})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_top:
                break;
        }
    }

    private void initView(){
        etCode = ButterKnife.findById(inputLayout, R.id.et_code);
        keyboardPopupwindow = NumberKeyboardPopupWindow.getInstance(this).onCreate(this);
        NumberKeyboardUtil.getInstance().setOnTouchListener(etCode, keyboardPopupwindow, this);
        NumberKeyboardUtil.getInstance().disableCopyAndPaste(etCode);
    }

    @Override
    public void showPopuWindow() {
        etCode.requestFocus();
        keyboardPopupwindow.showAsDropDown(llTop);
    }

    @Override
    public void dismiss() {
        etCode.getText().clear();
        etCode.clearFocus();
        keyboardPopupwindow.dismiss();
    }

    @Override
    public void insertStr(String str) {
        int index = etCode.getSelectionStart();
        if (index < 0 || index >= etCode.getText().toString().length()) {
            etCode.append(str);
        } else {
            etCode.getEditableText().insert(index, str);
        }
    }

    @Override
    public void check() {
        Toast.makeText(this, "check", Toast.LENGTH_SHORT).show();
    }
}
