package com.example.c1groupv2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.c1groupv2.R;
import com.example.c1groupv2.util.OnClickButtonDialogEditWordListener;

public class EditWordDialog extends Dialog implements View.OnClickListener {

    private EditText edtGermanword, edtEnglishmeaning, edtExample;
    //Edit Dialog
    private String german = "";
    private String english = "";
    private String example = "";

    private OnClickButtonDialogEditWordListener onClickButtonDialogEditWordListener;


    public EditWordDialog(@NonNull Context context, String german, String english, String example) {
        super(context);
        this.german = german;
        this.english = english;
        this.example = example;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setContentView(R.layout.dialog_edit_word);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_cancel_dialog_custom).setOnClickListener(this);
        findViewById(R.id.btn_ok_dialog_custom).setOnClickListener(this);
        edtGermanword = findViewById(R.id.edt_germanword);
        edtEnglishmeaning = findViewById(R.id.edt_englishmeaning);
        edtExample = findViewById(R.id.edt_example);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel_dialog_custom:
                if (onClickButtonDialogEditWordListener!=null){
                    onClickButtonDialogEditWordListener.onCancelButtonClick();
                }
                dismiss();
                break;
            case R.id.btn_ok_dialog_custom:
//                Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();

                //sdsf
                String editedGerman = String.valueOf(edtGermanword.getText());
                String editedEnglish = String.valueOf(edtEnglishmeaning.getText());
                String editedExample = String.valueOf(edtExample.getText());
                if (onClickButtonDialogEditWordListener!=null){
                    onClickButtonDialogEditWordListener.onOKButtonClick(editedGerman,editedEnglish,editedExample);
                }
                dismiss();
                break;
        }
    }

    @Override
    public void show() {
        super.show();
        edtGermanword.setText(german);
        edtEnglishmeaning.setText(english);
        edtExample.setText(example);
    }

    public void setGerman(String german) {
        this.german = german;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public void setOnClickButtonDialogEditWordListener(OnClickButtonDialogEditWordListener onClickButtonDialogEditWordListener) {
        this.onClickButtonDialogEditWordListener = onClickButtonDialogEditWordListener;
    }

}
