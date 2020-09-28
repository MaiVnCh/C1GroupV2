package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemPageEssayTips;

import java.util.ArrayList;

public class EssayTipsPageAdapter extends PagerAdapter {

    private ArrayList<ItemPageEssayTips> arrItemPage = new ArrayList<>();
    private Context context;

//    public EssayTipsPageAdapter(Context context) {
//        this.context = context;
////        initData();
//    }

    public EssayTipsPageAdapter(ArrayList<ItemPageEssayTips> arrItemPage, Context context) {
        this.arrItemPage = arrItemPage;
        this.context = context;

    }

//    private void initData() {
//        arrItemPage.add(new ItemPageEssayTips("1", "Die Beschreibung der Grafik", "Introduction: ...",
//                "Tip 1: ...........\nTip 2............", "Conclusion:"));
//        arrItemPage.add(new ItemPageEssayTips("20/8/20", "B.1", "Ergenzen Sie ...",
//                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
//        arrItemPage.add(new ItemPageEssayTips("20/8/20", "C.1", "Ergenzen Sie ...",
//                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
//        arrItemPage.add(new ItemPageEssayTips("20/8/20", "D.1", "Ergenzen Sie ...",
//                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
//        arrItemPage.add(new ItemPageEssayTips("20/8/20", "E.1", "Ergenzen Sie ...",
//                "Aaaaaaaaaaaaaaaaaa", "1. a; 2. b; 3.e"));
//
//    }

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_pager_essay_writing_tips, container, false);
        TextView tvEssayNummer = view.findViewById(R.id.tv_essay_number);
        TextView tvEssayTheme = view.findViewById(R.id.tv_essay_theme);
        TextView tvEssayIntroduction = view.findViewById(R.id.tv_essay_instruction);
        TextView tvEssayTips = view.findViewById(R.id.tv_essay_tips);
        TextView tvEssayConclusion = view.findViewById(R.id.tv_essay_conclusion);

        ItemPageEssayTips itemPageEssayTips = arrItemPage.get(position);
        tvEssayNummer.setText(itemPageEssayTips.getNumber());
        tvEssayTheme.setText(itemPageEssayTips.getTheme());
        tvEssayIntroduction.setText(itemPageEssayTips.getIntroduction());
        tvEssayTips.setText(itemPageEssayTips.getTips());
        tvEssayConclusion.setText(itemPageEssayTips.getConclusion());
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);

    }
}
