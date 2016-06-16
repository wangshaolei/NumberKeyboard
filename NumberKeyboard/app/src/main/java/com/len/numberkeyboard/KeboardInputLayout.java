package com.len.numberkeyboard;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shaolei on 2016/6/15.
 */
public class KeboardInputLayout extends LinearLayout implements View.OnFocusChangeListener, TextWatcher {

    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_hint)
    TextView tvHint;
    @BindView(R.id.iv_del)
    ImageView ivDel;

    private boolean hasFoucs;
    public KeboardInputLayout(Context context) {
        super(context);
        init();
    }

    public KeboardInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KeboardInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_keyboard_input, null);
        addView(view);
        ButterKnife.bind(this, view);
        setClearIconVisible(false);
        etCode.setOnFocusChangeListener(this);
        etCode.addTextChangedListener(this);
        ivDel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCode.getText().toString().trim().length() > 0) {
                    etCode.getText().delete(etCode.getSelectionStart() - 1, etCode.getSelectionStart());
                }
            }
        });
        ivDel.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (etCode.getText().toString().trim().length() > 0) {
                    etCode.getText().clear();
                }
                return false;
            }
        });
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        this.hasFoucs = hasFocus;
        if (hasFocus) {
            setClearIconVisible(etCode.getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
    }

    protected void setClearIconVisible(boolean visible) {
        if (visible) {
            tvHint.setVisibility(View.GONE);
            ivDel.setVisibility(View.VISIBLE);
        } else {
            tvHint.setVisibility(View.VISIBLE);
            ivDel.setVisibility(View.GONE);
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int count,
                              int after) {
        if (hasFoucs) {
            setClearIconVisible(s.length() > 0);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
