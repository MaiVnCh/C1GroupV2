package com.example.c1groupv2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c1groupv2.R;
import com.example.c1groupv2.util.OnItemAllTeilClickListener;

public class AllTeilFragment extends Fragment implements View.OnClickListener {

    public AllTeilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_teil, container, false);


    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        view.findViewById(R.id.ll_click_teilA).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilB).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilC).setOnClickListener(this);
        view.findViewById(R.id.ll_click_teilD).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_click_teilA:
                if (onItemAllTeilClickListener!= null){
                    onItemAllTeilClickListener.onClickItemAllTeil(v);
                }

                break;

        }

    }

    private OnItemAllTeilClickListener onItemAllTeilClickListener;

    public void setOnItemAllTeilClickListener(OnItemAllTeilClickListener onItemAllTeilClickListener) {
        this.onItemAllTeilClickListener = onItemAllTeilClickListener;
    }
}