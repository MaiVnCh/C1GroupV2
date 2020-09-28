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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddQADialog extends Dialog implements View.OnClickListener {

    private EditText edtAddQuestion, edtAddAnswer;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    private String question = "";
    private String answer = "";


    public AddQADialog(@NonNull Context context, String question, String answer) {
        super(context);
        this.question = question;
        this.answer = answer;
    }
    private OnClickAddQADialogListener onClickAddQADialogListener;


    public void setOnClickAddQADialogListener(OnClickAddQADialogListener onClickAddQADialogListener) {
        this.onClickAddQADialogListener = onClickAddQADialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setContentView(R.layout.dialog_add_qa);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_cancel_dialog_qa).setOnClickListener(this);
        findViewById(R.id.btn_ok_dialog_qa).setOnClickListener(this);
        edtAddQuestion = findViewById(R.id.edt_add_question);
        edtAddAnswer = findViewById(R.id.edt_add_answer);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel_dialog_qa:
                if (onClickAddQADialogListener!=null){
                    onClickAddQADialogListener.onCancelButtonClick();
                }
                dismiss();
                break;
            case R.id.btn_ok_dialog_qa:
//                Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();

                //sdsf
                String addedQuestion = String.valueOf(edtAddQuestion.getText());
                String addedAnswer = String.valueOf(edtAddAnswer.getText());
                if (onClickAddQADialogListener!=null){
                    onClickAddQADialogListener.onOKButtonClick(addedQuestion,addedAnswer);
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
