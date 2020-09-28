package com.example.c1groupv2.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.adapter.NewEssayAdapter;
import com.example.c1groupv2.fragment.EssayOfYoursFragment;
import com.example.c1groupv2.model.ItemNewEssay;
import com.example.c1groupv2.util.OnItemEssayClickListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EssayActivity extends AppCompatActivity {
//    private EssayOfYoursFragment essayOfYoursFragment;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    private RecyclerView rcNewEssays;
    private NewEssayAdapter newEssayAdapter;
    private ArrayList<ItemNewEssay> essayArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);
//        essayOfYoursFragment = new EssayOfYoursFragment();
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.container_essay_activity, essayOfYoursFragment)
//                .commit();
        database = FirebaseDatabase.getInstance();
        getNewExercies();
        initViews();


    }

    private void initViews() {
        rcNewEssays = findViewById(R.id.rc_new_essays);

        newEssayAdapter = new NewEssayAdapter(essayArrayList,this);

        rcNewEssays.setAdapter(newEssayAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rcNewEssays.setLayoutManager(linearLayoutManager);
        newEssayAdapter.setOnItemEssayClickListener(new OnItemEssayClickListener() {
            @Override
            public void onItemEssayClickListener(int position) {
                showAlert("Delete essay","Are you sure to delete this essay?", position);
            }
        });
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

    private void deleteEssay(int position){
        database.getReference("NEW_EXERCISES").child(essayArrayList.get(position).getId()).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                if (error == null){
                    Toast.makeText(EssayActivity.this, "Deleted successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(EssayActivity.this, "Delete unsuccessfully" + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        newEssayAdapter.notifyDataSetChanged();
    }
    private void showAlert(String title, String message, final int position){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteEssay(position);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}