package com.example.c1groupv2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.NewWordAdapter;
import com.example.c1groupv2.model.ItemNewWord;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class AddWordFragment extends Fragment implements View.OnClickListener {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private Button btnAddWord;
    private EditText edtGermanWord, edtEnglishMeaning, edtExample;
    public AddWordFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add_word, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        btnAddWord = getActivity().findViewById(R.id.btn_addword);
        btnAddWord.setOnClickListener(this);
        edtGermanWord = getActivity().findViewById(R.id.edt_germanword_add);
        edtEnglishMeaning = getActivity().findViewById(R.id.edt_englishmeaning_add);
        edtExample = getActivity().findViewById(R.id.edt_example_add);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_addword:
                String german = String.valueOf(edtGermanWord.getText());
                String english = String.valueOf(edtEnglishMeaning.getText());
                String example = String.valueOf(edtExample.getText());
                ItemNewWord itemNewWord = new ItemNewWord(german, english, example);
                databaseReference = database.getReference("NEW_WORDS").push();
                String id =databaseReference.getKey();
                itemNewWord.setId(id);
                databaseReference.setValue(itemNewWord, new DatabaseReference.CompletionListener() {
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