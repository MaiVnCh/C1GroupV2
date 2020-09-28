package com.example.c1groupv2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.c1groupv2.R;
import com.example.c1groupv2.fragment.AllTeilFragment;
import com.example.c1groupv2.fragment.TeilAFragmentWithDB;
import com.example.c1groupv2.util.OnItemAllTeilClickListener;

public class LessonActivity extends AppCompatActivity {
    private int lessonId;
    private AllTeilFragment allTeilFragment;
    private TeilAFragmentWithDB teilAFragmentWithDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        lessonId = lessonId();
        initObjects();
        getSupportFragmentManager().beginTransaction()
            .add(R.id.lesson_activity_container, allTeilFragment)
            .commit();

        clickAllteilItem();
    }

    private int lessonId() {
        Intent intent = getIntent();
        return intent.getIntExtra("LessonId", -1);
    }

    private void initObjects() {
        allTeilFragment = new AllTeilFragment();
        Bundle b = new Bundle();
        b.putString("lessonId", String.valueOf(lessonId));
        allTeilFragment.setArguments(b);
        teilAFragmentWithDB = new TeilAFragmentWithDB();
    }

    private void clickAllteilItem(){
    allTeilFragment.setOnItemAllTeilClickListener(new OnItemAllTeilClickListener() {
        @Override
        public void onClickItemAllTeil(View view) {
            switch (view.getId()){
                case R.id.ll_click_teilA:
                    teilAFragmentWithDB.setTeilType("Teil A");
                    teilAFragmentWithDB.setLessonId(lessonId);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.lesson_activity_container, teilAFragmentWithDB )
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.ll_click_teilB:
                    teilAFragmentWithDB.setTeilType("Teil B");
                    teilAFragmentWithDB.setLessonId(lessonId);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.lesson_activity_container, teilAFragmentWithDB )
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.ll_click_teilC:
                    teilAFragmentWithDB.setTeilType("Teil C");
                    teilAFragmentWithDB.setLessonId(lessonId);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.lesson_activity_container, teilAFragmentWithDB )
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.ll_click_teilD:
                    teilAFragmentWithDB.setTeilType("Teil D");
                    teilAFragmentWithDB.setLessonId(lessonId);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.lesson_activity_container, teilAFragmentWithDB )
                            .addToBackStack(null)
                            .commit();
                    break;
            }
        }
    });
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}