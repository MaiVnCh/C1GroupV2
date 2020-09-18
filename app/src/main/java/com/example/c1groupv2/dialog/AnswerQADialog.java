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
import com.example.c1groupv2.util.OnClickButtonDialogAnswerQAListener;
import com.example.c1groupv2.util.OnClickButtonDialogEditWordListener;

public class AnswerQADialog extends Dialog implements View.OnClickListener {

    private EditText edtQuestionAsked, edtAnswerNow;
    //Edit Dialog
    private String question = "";
    private String answer = "";

    public AnswerQADialog(@NonNull Context context, String question, String answer) {
        super(context);
        this.question = question;
        this.answer = answer;
    }

    private OnClickButtonDialogAnswerQAListener onClickButtonDialogAnswerQAListener;

    public void setOnClickButtonDialogAnswerQAListener(OnClickButtonDialogAnswerQAListener onClickButtonDialogAnswerQAListener) {
        this.onClickButtonDialogAnswerQAListener = onClickButtonDialogAnswerQAListener;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setContentView(R.layout.dialog_answer_qa);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_cancel_dialog_answer).setOnClickListener(this);
        findViewById(R.id.btn_ok_dialog_answer).setOnClickListener(this);
        edtQuestionAsked = findViewById(R.id.edt_question_asked);
        edtAnswerNow = findViewById(R.id.edt_answer_now);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cancel_dialog_answer:
                if (onClickButtonDialogAnswerQAListener!=null){
                    onClickButtonDialogAnswerQAListener.onCancelButtonClick();
                }
                dismiss();
                break;
            case R.id.btn_ok_dialog_answer:
                String sameQuestion = String.valueOf(edtQuestionAsked.getText());
                String answerMade = String.valueOf(edtAnswerNow.getText());
                if (onClickButtonDialogAnswerQAListener!=null){
                    onClickButtonDialogAnswerQAListener.onOKButtonClick(sameQuestion, answerMade);
                }
                dismiss();
                break;
        }
    }

    @Override
    public void show() {
        super.show();
        edtQuestionAsked.setText(question);
        edtAnswerNow.setText(answer);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
