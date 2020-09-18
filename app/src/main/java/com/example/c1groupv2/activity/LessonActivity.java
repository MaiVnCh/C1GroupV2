package com.example.c1groupv2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.c1groupv2.R;
import com.example.c1groupv2.fragment.AllTeilFragment;

public class LessonActivity extends AppCompatActivity {
    private AllTeilFragment allTeilFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initObjects();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.lesson_activity_container, allTeilFragment)
                .commit();
    }

    private void initObjects() {
        allTeilFragment = new AllTeilFragment();

    }

}