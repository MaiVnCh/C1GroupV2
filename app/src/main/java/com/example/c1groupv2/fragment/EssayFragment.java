package com.example.c1groupv2.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.activity.EssayActivity;
import com.example.c1groupv2.activity.LessonActivity;
import com.example.c1groupv2.adapter.EssayTipsPageAdapter;
import com.example.c1groupv2.adapter.NewEssayAdapter;
import com.example.c1groupv2.dialog.AddQADialog;
import com.example.c1groupv2.dialog.AddWritingTipDialog;
import com.example.c1groupv2.model.ItemNewEssay;
import com.example.c1groupv2.model.ItemPageEssayTips;
import com.example.c1groupv2.model.ItemQA;
import com.example.c1groupv2.util.OnClickAddQADialogListener;
import com.example.c1groupv2.util.OnClickAddWritingTipDialogListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EssayFragment extends Fragment implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;
    private ViewPager viewPager;
    private EssayTipsPageAdapter essayTipsPageAdapter;
    private ArrayList<ItemPageEssayTips> arrItemPage = new ArrayList<>();

    private EditText edtName, edtTheme, edtMindMap,edtIntroduction, edtBody, edtConclusion;
    private Button btnCancelWriting,btnAddEssay;
    private AddWritingTipDialog addWritingTipDialog;



    public EssayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_essay, container, false);
//        Toolbar toolbar = view.findViewById(R.id.my_toolbar);
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        getWritingTips();
        essayTipsPageAdapter = new EssayTipsPageAdapter(arrItemPage, getContext());

        database = FirebaseDatabase.getInstance();
        return view;
    }

    private void getWritingTips() {
        database.getReference("NEW_WRITING_TIPS").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrItemPage.clear();
                for (DataSnapshot child : snapshot.getChildren()) {
                    // Extract a Message object from the DataSnapshot
                    ItemPageEssayTips itemPageEssayTips = child.getValue(ItemPageEssayTips.class);
                    arrItemPage.add(itemPageEssayTips);
                    essayTipsPageAdapter.notifyDataSetChanged();
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
        viewPager= getActivity().findViewById(R.id.vp_essay_tips);
        viewPager.setAdapter(essayTipsPageAdapter);
        viewPager.setCurrentItem(0);
        edtName = getActivity().findViewById(R.id.edt_your_name);
        edtTheme = getActivity().findViewById(R.id.edt_essay_theme);
        edtMindMap = getActivity().findViewById(R.id.edt_essay_mindmap);
        edtIntroduction = getActivity().findViewById(R.id.edt_essay_introduction);
        edtBody = getActivity().findViewById(R.id.edt_essay_body);
        edtConclusion = getActivity().findViewById(R.id.edt_essay_conclusion);
        btnCancelWriting = getActivity().findViewById(R.id.btn_cancel_essaywriting);
        btnCancelWriting.setOnClickListener(this);
        btnAddEssay = getActivity().findViewById(R.id.btn_add_new_essay);
        btnAddEssay.setOnClickListener(this);

        // Floating button show essays
        FloatingActionButton fab = getActivity().findViewById(R.id.fab_your_essays);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentYourEssay = new Intent(getContext(), EssayActivity.class);
                startActivity(intentYourEssay);
            }
        });

        // Floating button add writing tips
        FloatingActionButton fabWritingTips = getActivity().findViewById(R.id.fab_add_writing_tip);
        fabWritingTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWritingTipDialog();
                if (!addWritingTipDialog.isShowing()) {
                    addWritingTipDialog.show();
                }
            }
        });

    }

    private void addWritingTipDialog() {
        addWritingTipDialog = new AddWritingTipDialog(getContext(), "", "","", "","");
        addWritingTipDialog.setOnClickAddWritingTipDialogListener(new OnClickAddWritingTipDialogListener() {
            @Override
            public void onCancelButtonClick() {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOKButtonClick(String newTipNumber, String newTipTheme, String newTipIntroduction, String newTipContent, String newTipConlcusion) {
                ItemPageEssayTips itemPageEssayTips = new ItemPageEssayTips(newTipNumber, newTipTheme, newTipIntroduction, newTipContent,newTipConlcusion);
                database = FirebaseDatabase.getInstance();
                databaseReference = database.getReference("NEW_WRITING_TIPS").push();
                String id =databaseReference.getKey();
                itemPageEssayTips.setId(id);
                databaseReference.setValue(itemPageEssayTips, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error == null) {
                            Toast.makeText(getContext(), "Added successfully.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Added unsuccessfully, " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_new_essay:
                String teilType = "New";
            String name = String.valueOf(edtName.getText());
            String theme = String.valueOf(edtTheme.getText());
            String mindmap = String.valueOf(edtMindMap.getText());
            String introduction = String.valueOf(edtIntroduction.getText());
            String body = String.valueOf(edtBody.getText());
            String conclusion = String.valueOf(edtConclusion.getText());
            String lessonID = "9";

            ItemNewEssay itemNewEssay = new ItemNewEssay(teilType, name, theme, mindmap, introduction, body,conclusion, lessonID);

            databaseReference = database.getReference("YOUR_ESSAYS").push();
            String id = databaseReference.getKey();
            itemNewEssay.setId(id);
            databaseReference.setValue(itemNewEssay, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                    if (error == null) {
                        Toast.makeText(getActivity(), "Added successfully.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Added unsuccessfully, " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            break;
            case R.id.btn_cancel_essaywriting:

                edtName.getText().clear();
                edtTheme.getText().clear();
                edtMindMap.getText().clear();
                edtIntroduction.getText().clear();
                edtBody.getText().clear();
                edtConclusion.getText().clear();
                break;
        }
    }
}
