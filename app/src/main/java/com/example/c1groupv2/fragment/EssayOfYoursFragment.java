package com.example.c1groupv2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.EssayTipsPageAdapter;
import com.example.c1groupv2.adapter.NewEssayAdapter;
import com.example.c1groupv2.model.ItemNewEssay;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EssayOfYoursFragment extends Fragment  {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    private RecyclerView rcNewEssays;
    private NewEssayAdapter newEssayAdapter;
    private ArrayList<ItemNewEssay> essayArrayList = new ArrayList<>();

    public EssayOfYoursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_essay, container, false);

        database = FirebaseDatabase.getInstance();
        getNewExercies();

        rcNewEssays =view.findViewById(R.id.rc_new_essays);

        newEssayAdapter = new NewEssayAdapter(essayArrayList,getActivity());

        rcNewEssays.setAdapter(newEssayAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcNewEssays.setLayoutManager(linearLayoutManager);


        return view;
    }

    private void getNewExercies() {
        database.getReference("NEW_EXERCISES").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                essayArrayList.clear();
                for (DataSnapshot child : snapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot
                    ItemNewEssay newEssay = child.getValue(ItemNewEssay.class);
                    essayArrayList.add(newEssay);
                    newEssayAdapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}