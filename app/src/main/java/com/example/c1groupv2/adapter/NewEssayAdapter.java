package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemNewEssay;
import com.example.c1groupv2.util.OnItemEssayClickListener;
import com.example.c1groupv2.util.OnItemTeilADetailClickListener;

import java.util.ArrayList;

public class NewEssayAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ItemNewEssay> newEssayArrayList = new ArrayList<>();
    private Context context;

    public NewEssayAdapter(ArrayList<ItemNewEssay> newEssayArrayList, Context context) {
        this.newEssayArrayList = newEssayArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_new_essay, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemNewEssay itemNewEssay = newEssayArrayList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvName.setText(itemNewEssay.getName());

        if (itemNewEssay.getTheme()!=null){
        viewHolder.tvTheme.setText(itemNewEssay.getTheme());}

        if (itemNewEssay.getMindmap()!=null){
        viewHolder.tvMindMap.setText(itemNewEssay.getMindmap());}

        if (itemNewEssay.getIntroduction()!=null){
            viewHolder.tvIntroduction.setText(itemNewEssay.getIntroduction());}
        if (itemNewEssay.getBody()!=null){
            viewHolder.tvBody.setText(itemNewEssay.getBody());}
        if (itemNewEssay.getConclusion()!=null){
            viewHolder.tvConlcusion.setText(itemNewEssay.getConclusion());}
    }


    @Override
    public int getItemCount() {
        return newEssayArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName, tvTheme, tvMindMap, tvIntroduction, tvBody, tvConlcusion;
        LinearLayout llOnClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_writer_name);
            tvTheme = itemView.findViewById(R.id.tv_essay_theme);
            tvIntroduction = itemView.findViewById(R.id.tv_essay_introduction);
            tvMindMap = itemView.findViewById(R.id.tv_essay_mindmap);
            tvBody = itemView.findViewById(R.id.tv_essay_body);
            tvConlcusion = itemView.findViewById(R.id.tv_essay_conclusion);

            llOnClick = itemView.findViewById(R.id.ll_essay_onclick);
            llOnClick.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_essay_onclick:
                    if ( onItemEssayClickListener != null){
                        onItemEssayClickListener.onItemEssayClickListener(getAdapterPosition());
                    }
                    break;
            }
        }
    }

    private OnItemEssayClickListener onItemEssayClickListener;

    public void setOnItemEssayClickListener(OnItemEssayClickListener onItemEssayClickListener) {
        this.onItemEssayClickListener = onItemEssayClickListener;
    }

    public ItemNewEssay getItemNewEssay (int position){return newEssayArrayList.get(position);}

}