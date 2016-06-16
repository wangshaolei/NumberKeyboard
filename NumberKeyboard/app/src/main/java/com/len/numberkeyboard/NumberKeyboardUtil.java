package com.len.numberkeyboard;

import android.os.Build;
import android.text.InputType;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.PopupWindow;

/**
 * Created by Shaolei on 2016/6/14.
 */
public class NumberKeyboardUtil implements View.OnTouchListener{
    private static NumberKeyboardUtil numberKeyboardUtil;
    private EditText mEditText;
    private PopupWindow mPopuWindow;
    private OnPopuWindowListener listener;

    public NumberKeyboardUtil() {
    }

    public static NumberKeyboardUtil getInstance() {
        if (numberKeyboardUtil == null) {
            numberKeyboardUtil = new NumberKeyboardUtil();
        }
        return numberKeyboardUtil;
    }

    public void setOnTouchListener(EditText mEditText, PopupWindow mPopuWindow, OnPopuWindowListener listener) {
        mEditText.setOnTouchListener(this);
        this.mEditText = mEditText;
        this.mPopuWindow = mPopuWindow;
        this.listener = listener;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO Auto-generated method stub
        int inputType = mEditText.getInputType();
        mEditText.setInputType(InputType.TYPE_NULL);
        mEditText.setInputType(inputType);
        mEditText.setSelection(mEditText.getText().toString().trim().length());

        if (mPopuWindow != null && !mPopuWindow.isShowing()) {
            listener.showPopuWindow();
        }
        return false;
    }

    /**
     * 禁用复制粘贴
     * @param editText
     */
    public void disableCopyAndPaste(EditText editText) {
        editText.setLongClickable(false);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        if (Build.VERSION.SDK_INT < 11) {
            editText.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                    menu.clear();
                }
            });
        } else {
            // 以下方法在api11以后才有
            editText.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
                @Override
                public void onDestroyActionMode(ActionMode mode) {
                }
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    return false;
                }
                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    return false;
                }
            });
        }
    }

    public interface OnPopuWindowListener {
        void showPopuWindow();
        void dismiss();
        void insertStr(String str);
        void check();
    }
}
