package com.example.c1groupv2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1groupv2.DatabaseManager;
import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.TeilADetailsAdapter;
import com.example.c1groupv2.model.ItemTeilADetails;
import com.example.c1groupv2.util.OnItemTeilADetailClickListener;

import java.util.ArrayList;


public class TeilAFragmentWithDB extends Fragment{
    private String teilType;
    private int lessonId;
    private TextView tvTeilKapitel;

    private RecyclerView rcTeilADetails;
    private TeilADetailsAdapter teilADetailsAdapter;
    private ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();

    private ShowUbungenFragment showUbungenFragment = new ShowUbungenFragment();

    public TeilAFragmentWithDB() {
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
//        if (teilType == "Teil A") {
//            aDetailsArrayList = DatabaseManager.getInstance(getContext()).getAllUbungenA();
//        } else if (teilType == "Teil B") {
            aDetailsArrayList = DatabaseManager.getInstance(getContext()).getAllUbungen(teilType, lessonId);
//        } else if (teilType == "Teil C") {
//            aDetailsArrayList = DatabaseManager.getInstance(getContext()).getAllUbungenC();
//        } else if (teilType == "Teil D") {
//            aDetailsArrayList = DatabaseManager.getInstance(getContext()).getAllUbungenD();
//        }

        View view =  inflater.inflate(R.layout.fragment_teil_a, container, false);
           rcTeilADetails =view.findViewById(R.id.rc_teila_details);
           tvTeilKapitel = view.findViewById(R.id.tv_teil_kapitel);
           tvTeilKapitel.setText("Kapitel " +String.valueOf(lessonId) + " - " +teilType);
           teilADetailsAdapter = new TeilADetailsAdapter(aDetailsArrayList,getActivity());

           rcTeilADetails.setAdapter(teilADetailsAdapter);
           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
           linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
           rcTeilADetails.setLayoutManager(linearLayoutManager);
           initViews();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {

        teilADetailsAdapter.setOnItemTeilADetailClickListener(new OnItemTeilADetailClickListener() {
            @Override
            public void onItemTeilADetailClickListener(int position) {
                ItemTeilADetails clickedItem = teilADetailsAdapter.getItemTeilADetails(position);
                if (showUbungenFragment !=null) {
                    showUbungenFragment.setItemTeilADetails(clickedItem);
                }
                getFragmentManager().beginTransaction()
                        .replace(R.id.lesson_activity_container, showUbungenFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }

    public void setTeilType(String teilType) {
        this.teilType = teilType;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }
}