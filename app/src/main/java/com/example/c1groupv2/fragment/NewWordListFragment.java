package com.example.c1groupv2.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.NewWordAdapter;
import com.example.c1groupv2.dialog.EditWordDialog;
import com.example.c1groupv2.model.ItemNewWord;
import com.example.c1groupv2.util.OnClickButtonDialogEditWordListener;
import com.example.c1groupv2.util.OnDeleteButtonClickListener;
import com.example.c1groupv2.util.OnItemWordClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class NewWordListFragment extends Fragment {

    private static final String TAG = "message cancel" ;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private RecyclerView rcNewWords;
    private NewWordAdapter newWordAdapter;
    private ArrayList<ItemNewWord> wordArrayList = new ArrayList<>();
    private int positionEdit;

    //For Edit Dialog
    private EditWordDialog editWordDialog;
    private ItemNewWord itemNewWord;
    public NewWordListFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_new_word_list, container, false);
        database = FirebaseDatabase.getInstance();
        getData();

//        exerciseHomePageAdapter = new ExerciseHomePageAdapter(getContext());

        rcNewWords =view.findViewById(R.id.rc_home_newwords);

        newWordAdapter = new NewWordAdapter(wordArrayList,getActivity());

        rcNewWords.setAdapter(newWordAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcNewWords.setLayoutManager(linearLayoutManager);

        return view;
    }
    private void getData() {
       database.getReference("NEW_WORDS").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                wordArrayList.clear();
                for (DataSnapshot child : snapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot
                    ItemNewWord newWord = child.getValue(ItemNewWord.class);
                    String germanWord = newWord.getGermanWord();
                    wordArrayList.add(newWord);
                    newWordAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "messages:onCancelled:" + error.getMessage());

            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {

        newWordAdapter.setOnItemWordClickListener(new OnItemWordClickListener() {
            @Override
            public void onItemWordClickListener(int position) {
                positionEdit = position;
                itemNewWord = newWordAdapter.getItemNewWord(position);
                String id = String.valueOf(itemNewWord.getId());
                String german = String.valueOf(itemNewWord.getGermanWord());
                String english = String.valueOf(itemNewWord.getEnglishMeaning());
                String example = String.valueOf(itemNewWord.getExample());

                Toast.makeText(getContext(), id, Toast.LENGTH_LONG).show();
                editDialog();
                if (!editWordDialog.isShowing()) {
                    editWordDialog.setGerman(german);
                    editWordDialog.setEnglish(english);
                    editWordDialog.setExample(example);
                    editWordDialog.show();
                }

            }
        });

        newWordAdapter.setOnDeleteButtonClickListener(new OnDeleteButtonClickListener() {
            @Override
            public void onDeleteButtonClickListener(int position) {
                showAlert( "Delete word","Are you sure to delete this word?", position);

            }
        });
    }

    private void editDialog(){
        editWordDialog = new EditWordDialog(getContext(), "German...", "English...", "Example...");

        editWordDialog.setOnClickButtonDialogEditWordListener(new OnClickButtonDialogEditWordListener() {
            @Override
            public void onCancelButtonClick() {

            }

            @Override
            public void onOKButtonClick(String editedGerman, String editedEnglish, String editedExample) {

                wordArrayList.get(positionEdit).setGermanWord(editedGerman);
                wordArrayList.get(positionEdit).setEnglishMeaning(editedEnglish);
                wordArrayList.get(positionEdit).setExample(editedExample);

                databaseReference = database.getReference("NEW_WORDS").child(wordArrayList.get(positionEdit).getId());
                databaseReference.setValue(wordArrayList.get(positionEdit));
                newWordAdapter.notifyDataSetChanged();

            }
        });
    }
    private void deleteWord(int position){
        Toast.makeText(getContext(), "Da xoa", Toast.LENGTH_LONG).show();
        database.getReference("NEW_WORDS").child(wordArrayList.get(position).getId()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null){
                    Toast.makeText(getContext(), "Xoa thanh cong", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Xoa that bai, " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        newWordAdapter.notifyDataSetChanged();
    }
    private void showAlert(String title, String message, final int position){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteWord(position);
            }
        });

        builder.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}