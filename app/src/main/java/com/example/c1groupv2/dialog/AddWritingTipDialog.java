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
import com.example.c1groupv2.util.OnClickAddQADialogListener;
import com.example.c1groupv2.util.OnClickAddWritingTipDialogListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddWritingTipDialog extends Dialog implements View.OnClickListener {

    private EditText edtAddTipNumber, edtAddTipTheme, edtAddTipIntroduction, edtAddTipContent, edtAddTipConclusion;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    private String number = "";
    private String theme = "";
    private String introduction = "";
    private String content = "";
    private String conclusion = "";

    public AddWritingTipDialog(@NonNull Context context, String number, String theme, String introduction, String content, String conclusion) {
        super(context);
        this.number = number;
        this.theme = theme;
        this.introduction = introduction;
        this.content = content;
        this.conclusion = conclusion;
    }

    private OnClickAddWritingTipDialogListener  onClickAddWritingTipDialogListener;

    public void setOnClickAddWritingTipDialogListener(OnClickAddWritingTipDialogListener onClickAddWritingTipDialogListener) {
        this.onClickAddWritingTipDialogListener = onClickAddWritingTipDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setContentView(R.layout.dialog_add_writing_tip);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_cancel_dialog_writing_tip).setOnClickListener(this);
        findViewById(R.id.btn_ok_dialog_writing_tip).setOnClickListener(this);
        edtAddTipNumber = findViewById(R.id.edt_add_tip_number);
        edtAddTipTheme = findViewById(R.id.edt_add_writing_theme);
        edtAddTipIntroduction = findViewById(R.id.edt_add_tip_introduction);
        edtAddTipContent = findViewById(R.id.edt_add_tip_content);
        edtAddTipConclusion = findViewById(R.id.edt_add_tip_conclusion);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel_dialog_writing_tip:
                if (onClickAddWritingTipDialogListener!=null){
                    onClickAddWritingTipDialogListener.onCancelButtonClick();
                }
                dismiss();
                break;
            case R.id.btn_ok_dialog_writing_tip:
//                Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();

                //sdsf
                String addedTipNumber = String.valueOf(edtAddTipNumber.getText());
                String addedTipTheme = String.valueOf(edtAddTipTheme.getText());
                String addedTipIntroduction = String.valueOf(edtAddTipIntroduction.getText());
                String addedTipContent = String.valueOf(edtAddTipContent.getText());
                String addedTipConclusion = String.valueOf(edtAddTipConclusion.getText());

                if (onClickAddWritingTipDialogListener!=null){
                    onClickAddWritingTipDialogListener.onOKButtonClick(addedTipNumber,addedTipTheme,addedTipIntroduction,addedTipContent,addedTipConclusion);
                }
                dismiss();
                break;
        }
    }




//    @Override
//    public void show() {
//        super.show();
//        edtGermanword.setText(german);
//        edtEnglishmeaning.setText(english);
//        edtExample.setText(example);
//    }

//    public void setGerman(String german) {
//        this.german = german;
//    }
//
//    public void setEnglish(String english) {
//        this.english = english;
//    }
//
//    public void setExample(String example) {
//        this.example = example;
//    }
}
