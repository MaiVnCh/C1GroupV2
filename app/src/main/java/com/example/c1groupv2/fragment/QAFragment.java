package com.example.c1groupv2.fragment;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.NewWordAdapter;
import com.example.c1groupv2.adapter.QAAdapter;
import com.example.c1groupv2.dialog.AddQADialog;
import com.example.c1groupv2.dialog.AnswerQADialog;
import com.example.c1groupv2.dialog.EditWordDialog;
import com.example.c1groupv2.model.ItemNewWord;
import com.example.c1groupv2.model.ItemQA;
import com.example.c1groupv2.util.OnClickAddQADialogListener;
import com.example.c1groupv2.util.OnClickButtonDialogAnswerQAListener;
import com.example.c1groupv2.util.OnClickButtonDialogEditWordListener;
import com.example.c1groupv2.util.OnItemQAClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QAFragment extends Fragment {
    private static final String TAG = "data";
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private RecyclerView rcQA;
    private QAAdapter qaAdapter;
    private AddQADialog addQADialog;
    private ArrayList<ItemQA> qaArrayList = new ArrayList<>();
    private int positionQA;
    private int positionEditQA;
    private ItemQA itemQA;
    private AnswerQADialog answerQADialog;

    public QAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_q_a, container, false);
        database = FirebaseDatabase.getInstance();
        getDataQA();

        rcQA =view.findViewById(R.id.rc_qa);
        qaAdapter = new QAAdapter(qaArrayList,getActivity());
        rcQA.setAdapter(qaAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcQA.setLayoutManager(linearLayoutManager);

        return view;
    }




    private void getDataQA() {
        database.getReference("NEW_QA").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                qaArrayList.clear();
                for (DataSnapshot child : snapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot
                    ItemQA itemQA = child.getValue(ItemQA.class);
                    qaArrayList.add(itemQA);
                    qaAdapter.notifyDataSetChanged();
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
        initViews();
    }

    private void initViews() {
        // Floating button
        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addQADialog();
                if (!addQADialog.isShowing()) {
                    addQADialog.show();
                }
            }
        });

        // Click on each item QA
        qaAdapter.setOnItemQAClickListener(new OnItemQAClickListener() {
            @Override
            public void onItemQAClickListener(int position) {
                positionEditQA = position;
                itemQA = qaAdapter.getItemQA(position);
                String id = String.valueOf(itemQA.getId());
                String question = String.valueOf(itemQA.getQuestion());
                String answer = String.valueOf(itemQA.getAnswer());

                Toast.makeText(getContext(), question, Toast.LENGTH_LONG).show();
                answerQADialog();
                if (!answerQADialog.isShowing()) {
                    answerQADialog.setQuestion(question);
                    answerQADialog.setAnswer(answer);
                    answerQADialog.show();
                }
            }
        });

    }

    private void answerQADialog() {
        answerQADialog = new AnswerQADialog(getContext(), "My question is...", "My answer is...");

        answerQADialog.setOnClickButtonDialogAnswerQAListener(new OnClickButtonDialogAnswerQAListener() {
            @Override
            public void onCancelButtonClick() {
                Toast.makeText(getContext(), "Answer cancelled.", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onOKButtonClick(String question, String answer) {

                qaArrayList.get(positionEditQA).setQuestion(question);
                qaArrayList.get(positionEditQA).setAnswer(answer);

                databaseReference = database.getReference("NEW_QA").child(qaArrayList.get(positionEditQA).getId());
                databaseReference.setValue(qaArrayList.get(positionEditQA));
                qaAdapter.notifyDataSetChanged();

            }
        });

    }


    private void addQADialog() {
         addQADialog = new AddQADialog(getContext(), "", "");

        addQADialog.setOnClickAddQADialogListener(new OnClickAddQADialogListener() {
            @Override
            public void onCancelButtonClick() {
                Toast.makeText(getContext(), "cancel roi", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onOKButtonClick(String addedQuestion, String addedAnswer) {
                ItemQA itemQA = new ItemQA(addedQuestion, addedAnswer);
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("NEW_QA").push();
                String id =databaseReference.getKey();
                itemQA.setId(id);
                databaseReference.setValue(itemQA, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) {
                            Toast.makeText(getContext(), "Added question successfully.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Added question unsuccessfully, " + error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });

    }

}