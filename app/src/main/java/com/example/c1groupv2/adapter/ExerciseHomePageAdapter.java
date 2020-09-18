package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemPageExerciseHome;
import com.example.c1groupv2.R;

import java.util.ArrayList;

public class ExerciseHomePageAdapter extends PagerAdapter {

    private ArrayList<ItemPageExerciseHome> arrItemPage = new ArrayList<>();
    private Context context;

    public ExerciseHomePageAdapter(Context context) {
        this.context = context;
        initData();
    }

    private void initData() {
        arrItemPage.add(new ItemPageExerciseHome("20/8/20", "A.1", "Ergenzen Sie ...",
                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
        arrItemPage.add(new ItemPageExerciseHome("20/8/20", "B.1", "Ergenzen Sie ...",
                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
        arrItemPage.add(new ItemPageExerciseHome("20/8/20", "C.1", "Ergenzen Sie ...",
                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
        arrItemPage.add(new ItemPageExerciseHome("20/8/20", "D.1", "Ergenzen Sie ...",
                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
        arrItemPage.add(new ItemPageExerciseHome("20/8/20", "E.1", "Ergenzen Sie ...",
                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));

    }

    @Override
    public int getCount() {
        return arrItemPage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object.equals(view);
    }

    @NonNull
    @Override
    public View instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pager_todayexercise, container, false);
        TextView tvDate = view.findViewById(R.id.tv_date);
        TextView tvNumber = view.findViewById(R.id.tv_exercises_number);
        TextView tvInstruction = view.findViewById(R.id.tv_instruction);
        TextView tvContent = view.findViewById(R.id.tv_content);
        TextView tvKey = view.findViewById(R.id.tv_key);

        ItemPageExerciseHome itemPageExerciseHome = arrItemPage.get(position);
        tvDate.setText(itemPageExerciseHome.getDate());
        tvNumber.setText(itemPageExerciseHome.getNumber());
        tvInstruction.setText(itemPageExerciseHome.getInstruction());
        tvContent.setText(itemPageExerciseHome.getContent());
        tvKey.setText(itemPageExerciseHome.getKey());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);

    }
}
