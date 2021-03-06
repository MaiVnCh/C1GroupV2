package com.example.c1groupv2.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemTeilADetails;

public class ShowUbungenFragment extends Fragment implements View.OnClickListener {

    private TextView edtNumber, edtTheme, edtInstruction, edtExample, edtContent, edtAnswer;
    private ItemTeilADetails itemTeilADetails;
    private Button btnBack;


    public ShowUbungenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_ubungen, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        edtNumber = getActivity().findViewById(R.id.edt_edit_number);
        edtTheme = getActivity().findViewById(R.id.edt_edit_theme);
        edtInstruction = getActivity().findViewById(R.id.edt_edit_instruction);
        edtExample = getActivity().findViewById(R.id.edt_edit_example);
        edtContent = getActivity().findViewById(R.id.edt_edit_content);
        edtAnswer = getActivity().findViewById(R.id.edt_edit_answer);
        if (itemTeilADetails != null) {
            edtNumber.setText(itemTeilADetails.getNumber());
            if (itemTeilADetails.getTheme()!=null){
            edtTheme.setText(itemTeilADetails.getTheme());}

            if (itemTeilADetails.getInstruction()!=null){
            edtInstruction.setText(itemTeilADetails.getInstruction());}

            if (itemTeilADetails.getExample()!=null){
            edtExample.setText(itemTeilADetails.getExample());}

            if (itemTeilADetails.getContent()!=null){
            edtContent.setText(itemTeilADetails.getContent());}

            if (itemTeilADetails.getAnswer()!=null){
            edtAnswer.setText("Keys: \n" + itemTeilADetails.getAnswer());
            }
        }
        btnBack = getActivity().findViewById(R.id.btn_edit_detail);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_edit_detail:
                getFragmentManager().popBackStack();
                   break;
                }
        }

    public void setItemTeilADetails(ItemTeilADetails itemTeilADetails) {
        this.itemTeilADetails = itemTeilADetails;
    }
}
