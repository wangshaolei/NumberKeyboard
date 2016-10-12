# NumberKeyboard
##Custom keyboardview with two ways:

1. Override systems's sys.xml of keyboardview
2. Custom the layout and slove the touchListener's question and so on...

###For example: MeiTuan's Merchant or NuoMi's Merchant app, Number Keyboard

####Show parts codes:

```java
    public class MainActivity extends AppCompatActivity implements View.OnClickListener, NumberKeyboardUtil.OnPopuWindowListener
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
```

#Thanks:

[Jakewharton-Butterknife](https://github.com/JakeWharton/butterknife)



![](https://github.com/wangshaolei/NumberKeyboard/blob/master/img/1.png)    ![](https://github.com/wangshaolei/NumberKeyboard/blob/master/img/2.png)

