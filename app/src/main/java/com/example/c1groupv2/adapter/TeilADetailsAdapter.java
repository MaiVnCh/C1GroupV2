package com.example.c1groupv2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c1groupv2.R;
import com.example.c1groupv2.model.ItemTeilADetails;
import com.example.c1groupv2.util.OnItemTeilADetailClickListener;

import java.util.ArrayList;

public class TeilADetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ItemTeilADetails> aDetailsArrayList = new ArrayList<>();
    private Context context;


    public TeilADetailsAdapter(Context context) {
        this.context = context;
    }

    public TeilADetailsAdapter(ArrayList<ItemTeilADetails> aDetailsArrayList, Context context) {
        this.aDetailsArrayList = aDetailsArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_teila_details, parent, false);
        return new ViewHolder(view);

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemTeilADetails itemTeilADetails = aDetailsArrayList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvNumber.setText(itemTeilADetails.getNumber());

        if (itemTeilADetails.getTheme()!=null){
        viewHolder.tvTheme.setText(itemTeilADetails.getTheme());}

        if (itemTeilADetails.getInstruction()!=null){
        viewHolder.tvInstruction.setText(itemTeilADetails.getInstruction());}

        if (itemTeilADetails.getExample()!=null){
            viewHolder.tvExample.setText(itemTeilADetails.getExample());}
        if (itemTeilADetails.getContent()!=null){
            viewHolder.tvContent.setText(itemTeilADetails.getContent() + "\n\n(Click for keys)");}
//        viewHolder.tvAnswer.setText(itemTeilADetails.getAnswer());
    }


    @Override
    public int getItemCount() {
        return aDetailsArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNumber, tvTheme, tvInstruction, tvExample, tvContent, tvAnswer;
        LinearLayout llOnClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.tv_ubungen_number);
            tvTheme = itemView.findViewById(R.id.tv_ubungen_theme);
            tvInstruction = itemView.findViewById(R.id.tv_ubungen_instruction);
            tvExample = itemView.findViewById(R.id.tv_ubungen_example);
            tvContent = itemView.findViewById(R.id.tv_ubungen_content);
//            tvAnswer = itemView.findViewById(R.id.tv_ubungen_answer);

            llOnClick = itemView.findViewById(R.id.ll_ubungen_onclick);
            llOnClick.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_ubungen_onclick:
                    if ( onItemTeilADetailClickListener != null){
                        onItemTeilADetailClickListener.onItemTeilADetailClickListener(getAdapterPosition());
                    }
                    break;
            }
        }
    }

    private OnItemTeilADetailClickListener onItemTeilADetailClickListener;

    public void setOnItemTeilADetailClickListener(OnItemTeilADetailClickListener onItemTeilADetailClickListener) {
        this.onItemTeilADetailClickListener = onItemTeilADetailClickListener;
    }
    public ItemTeilADetails getItemTeilADetails (int position){return aDetailsArrayList.get(position);}

}