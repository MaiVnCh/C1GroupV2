package com.example.c1groupv2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.c1groupv2.R;
import com.example.c1groupv2.activity.LessonActivity;

public class BrowseFragment extends Fragment implements View.OnClickListener {
    private Button btnLesson1, btnLesson2,btnLesson3,btnLesson4,btnLesson5,btnLesson6,btnLesson7,btnLesson8;

    public BrowseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews( View view) {
        btnLesson1= view.findViewById(R.id.btn_lesson1);
        btnLesson2= view.findViewById(R.id.btn_lesson2);
        btnLesson3= view.findViewById(R.id.btn_lesson3);
        btnLesson4= view.findViewById(R.id.btn_lesson4);
        btnLesson5= view.findViewById(R.id.btn_lesson5);
        btnLesson6= view.findViewById(R.id.btn_lesson6);
        btnLesson7= view.findViewById(R.id.btn_lesson7);
        btnLesson8= view.findViewById(R.id.btn_lesson8);
        btnLesson1.setOnClickListener(this);
        btnLesson2.setOnClickListener(this);
        btnLesson3.setOnClickListener(this);
        btnLesson4.setOnClickListener(this);
        btnLesson5.setOnClickListener(this);
        btnLesson6.setOnClickListener(this);
        btnLesson7.setOnClickListener(this);
        btnLesson8.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_lesson1:
                Intent intentLesson1 = new Intent(getContext(), LessonActivity.class);
                intentLesson1.putExtra("LessonId", 1);
                startActivity(intentLesson1);
            break;
            case R.id.btn_lesson2:
                Intent intentLesson2 = new Intent(getContext(), LessonActivity.class);
                intentLesson2.putExtra("LessonId", 2);
                startActivity(intentLesson2);
                break;
            case R.id.btn_lesson3:
                Intent intentLesson3 = new Intent(getContext(), LessonActivity.class);
                intentLesson3.putExtra("LessonId", 3);
                startActivity(intentLesson3);
                break;
            case R.id.btn_lesson4:
                Intent intentLesson4 = new Intent(getContext(), LessonActivity.class);
                intentLesson4.putExtra("LessonId", 4);
                startActivity(intentLesson4);
                break;
            case R.id.btn_lesson5:
                Intent intentLesson5 = new Intent(getContext(), LessonActivity.class);
                intentLesson5.putExtra("LessonId", 5);
                startActivity(intentLesson5);
                break;

            case R.id.btn_lesson6:
                Intent intentLesson6 = new Intent(getContext(), LessonActivity.class);
                intentLesson6.putExtra("LessonId", 6);
                startActivity(intentLesson6);
                break;
            case R.id.btn_lesson7:
                Intent intentLesson7 = new Intent(getContext(), LessonActivity.class);
                intentLesson7.putExtra("LessonId", 7);
                startActivity(intentLesson7);
                break;
            case R.id.btn_lesson8:
                Intent intentLesson8 = new Intent(getContext(), LessonActivity.class);
                intentLesson8.putExtra("LessonId", 8);
                startActivity(intentLesson8);
                break;

        }
    }
}