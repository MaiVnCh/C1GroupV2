package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemNewWord;
import com.example.c1groupv2.model.ItemQA;
import com.example.c1groupv2.util.OnDeleteButtonClickListener;
import com.example.c1groupv2.util.OnItemQAClickListener;
import com.example.c1groupv2.util.OnItemWordClickListener;

import java.util.ArrayList;

public class QAAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ItemQA> qaArrayList = new ArrayList<>();
    private Context context;


    public QAAdapter(Context context) {
        this.context = context;
    }

    public QAAdapter(ArrayList<ItemQA> qaArrayList, Context context) {
        this.qaArrayList = qaArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_qa, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemQA itemQA = qaArrayList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
//        viewHolder.imvAvatar.setImageResource(itemNewWord.getGermanWord());
        viewHolder.tvQuestion.setText(itemQA.getQuestion());
        viewHolder.tvAnswer.setText(itemQA.getAnswer());


    }


    @Override
    public int getItemCount() {
        return qaArrayList.size();
    }
    public ItemQA getItemQA (int position){return qaArrayList.get(position);}


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        ImageView imvAvatar;
        TextView tvQuestion, tvAnswer;
        LinearLayout llOnClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            imvAvatar = itemView.findViewById(R.id.imv_avatar);
            tvQuestion = itemView.findViewById(R.id.tv_question);
            tvAnswer= itemView.findViewById(R.id.tv_answer);
            llOnClick = itemView.findViewById(R.id.qa_onclick);
            llOnClick.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.qa_onclick:
                    if ( onItemQAClickListener != null){
                        onItemQAClickListener.onItemQAClickListener(getAdapterPosition());
                    }
                    break;

            }
        }


    }
    private OnItemQAClickListener onItemQAClickListener;

    public void setOnItemQAClickListener(OnItemQAClickListener onItemQAClickListener) {
        this.onItemQAClickListener = onItemQAClickListener;
    }

//    private OnDeleteButtonClickListener onDeleteButtonClickListener;
//
//    public void setOnDeleteButtonClickListener(OnDeleteButtonClickListener onDeleteButtonClickListener) {
//        this.onDeleteButtonClickListener = onDeleteButtonClickListener;
//    }
}