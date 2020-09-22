package com.example.c1groupv2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.ExerciseHomePageAdapter;
import com.example.c1groupv2.model.ItemTeilADetails;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExercisesFragment extends Fragment implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    private ViewPager viewPager;
    private ExerciseHomePageAdapter exerciseHomePageAdapter;
    private EditText edtNumber, edtTheme, edtInstruction, edtExample,edtContent, edtAnswer;
    private Button btnAddTeilADetail;
    public ExercisesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_exercises, container, false);
        exerciseHomePageAdapter = new ExerciseHomePageAdapter(getContext());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }
    private void initViews() {
        viewPager= getActivity().findViewById(R.id.vp_home_exercisetoday);
        viewPager.setAdapter(exerciseHomePageAdapter);
        viewPager.setCurrentItem(0);
        edtNumber = getActivity().findViewById(R.id.edt_ubungen_number);
        edtTheme = getActivity().findViewById(R.id.edt_ubungen_theme);
        edtInstruction = getActivity().findViewById(R.id.edt_ubungen_instruction);
        edtExample = getActivity().findViewById(R.id.edt_ubungen_example);
        edtContent = getActivity().findViewById(R.id.edt_ubungen_content);
        edtAnswer = getActivity().findViewById(R.id.edt_ubungen_answer);
        btnAddTeilADetail = getActivity().findViewById(R.id.btn_add_teila_detail);
        btnAddTeilADetail.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_teila_detail:
            String teilType = "Teil A";
            String number = String.valueOf(edtNumber.getText());
            String theme = String.valueOf(edtTheme.getText());
            String instruction = String.valueOf(edtInstruction.getText());
            String example = String.valueOf(edtExample.getText());
            String content = String.valueOf(edtContent.getText());
            String answer = String.valueOf(edtAnswer.getText());
            String lessonId = "1";
            ItemTeilADetails itemTeilADetails = new ItemTeilADetails(teilType, number, theme, instruction, example, content, answer, lessonId);

            databaseReference = database.getReference("NEW_TEILA_UBUNGEN").push();
            int id = Integer.parseInt(databaseReference.getKey());
            itemTeilADetails.setId(id);
            databaseReference.setValue(itemTeilADetails, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    if (error == null) {
                        Toast.makeText(getActivity(), "Added successfully.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getActivity(), "Added unsuccessfully, " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
            break;
        }
    }
}