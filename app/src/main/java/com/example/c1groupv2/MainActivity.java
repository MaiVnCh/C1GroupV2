package com.example.c1groupv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.c1groupv2.adapter.NaviAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private NaviAdapter naviAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        naviAdapter = new NaviAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.vp_main_navi);
        viewPager.setAdapter(naviAdapter);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.page_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.page_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.page_3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.page_4:
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.page_5:
                        viewPager.setCurrentItem(4);
                        break;

                }
                return false;
            }
        });
    }
}