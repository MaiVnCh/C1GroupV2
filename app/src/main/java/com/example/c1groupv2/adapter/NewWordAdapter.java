package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemNewWord;
import com.example.c1groupv2.util.OnDeleteButtonClickListener;
import com.example.c1groupv2.util.OnItemWordClickListener;

import java.util.ArrayList;

public class NewWordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ItemNewWord> newWordArrayList = new ArrayList<>();
    private Context context;


    public NewWordAdapter(Context context) {
        this.context = context;
    }

    public NewWordAdapter(ArrayList<ItemNewWord> newWordArrayList, Context context) {
        this.newWordArrayList = newWordArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_newword, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemNewWord itemNewWord = newWordArrayList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvGermanWord.setText(itemNewWord.getGermanWord());
        viewHolder.tvEnglishMeaning.setText(itemNewWord.getEnglishMeaning());
        viewHolder.tvExample.setText(itemNewWord.getExample());

        if (position % 2 == 0) {
            viewHolder.tvGermanWord.setBackgroundResource(R.color.colorSecondaryLight);
            viewHolder.tvEnglishMeaning.setBackgroundResource(R.color.colorSecondaryLight);
            viewHolder.tvExample.setBackgroundResource(R.color.colorSecondaryLight);
        }
    }


    @Override
    public int getItemCount() {
        return newWordArrayList.size();
    }
    public ItemNewWord getItemNewWord (int position){return newWordArrayList.get(position);}


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvGermanWord, tvEnglishMeaning, tvExample;
        Button btnDelete;
        LinearLayout llOnClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvGermanWord = itemView.findViewById(R.id.tv_germanword);
            tvEnglishMeaning = itemView.findViewById(R.id.tv_englishmeaning);
            tvExample = itemView.findViewById(R.id.tv_example);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnDelete.setOnClickListener(this);
            llOnClick = itemView.findViewById(R.id.tumoi_onclick);
            llOnClick.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tumoi_onclick:
                    if ( onItemWordClickListener != null){
                        onItemWordClickListener.onItemWordClickListener(getAdapterPosition());
                    }
                    break;

                case R.id.btn_delete:
                    if (onDeleteButtonClickListener != null){
                        onDeleteButtonClickListener.onDeleteButtonClickListener(getAdapterPosition());
                    }
                    break;
            }
        }


    }
    private OnItemWordClickListener onItemWordClickListener;

    public void setOnItemWordClickListener(OnItemWordClickListener onItemWordClickListener) {
        this.onItemWordClickListener = onItemWordClickListener;
    }
    private OnDeleteButtonClickListener onDeleteButtonClickListener;

    public void setOnDeleteButtonClickListener(OnDeleteButtonClickListener onDeleteButtonClickListener) {
        this.onDeleteButtonClickListener = onDeleteButtonClickListener;
    }
}