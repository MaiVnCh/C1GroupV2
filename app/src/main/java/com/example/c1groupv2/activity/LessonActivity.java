package com.example.c1groupv2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.c1groupv2.DatabaseManager;
import com.example.c1groupv2.R;
import com.example.c1groupv2.fragment.AllTeilFragment;
import com.example.c1groupv2.fragment.ShowUbungenFragment;
import com.example.c1groupv2.fragment.TeilAFragment;
import com.example.c1groupv2.fragment.TeilAFragmentWithDB;
import com.example.c1groupv2.util.OnItemAllTeilClickListener;

public class LessonActivity extends AppCompatActivity {
    private AllTeilFragment allTeilFragment;
    private TeilAFragmentWithDB teilAFragmentWithDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        initObjects();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.lesson_activity_container, allTeilFragment)
                .commit();
        clickAllteilItem();
    }

    private void initObjects() {
        allTeilFragment = new AllTeilFragment();
        teilAFragmentWithDB = new TeilAFragmentWithDB();
    }

    private void clickAllteilItem(){
    allTeilFragment.setOnItemAllTeilClickListener(new OnItemAllTeilClickListener() {
        @Override
        public void onClickItemAllTeil(View view) {
            switch (view.getId()){
                case R.id.ll_click_teilA:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.lesson_activity_container, teilAFragmentWithDB )
                            .addToBackStack(null)
                            .commit();
                    break;
            }
        }
    });
    }


}