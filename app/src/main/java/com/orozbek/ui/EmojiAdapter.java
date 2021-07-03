package com.orozbek.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orozbek.data.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {

    private List<Card<String>> list = new LinkedList<>();
    private onCardClick listener;

    public void addItems(List<Card<String>> list, onCardClick listener){
        this.list = list;
        this.listener = listener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cardTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardTv = itemView.findViewById(R.id.text_item);
        }

        @SuppressLint("ResourceAsColor")
        public void onBind(Card<String>card){
            if (card.isFaceUp()){
                cardTv.setText(card.getContent());
            }else {
                cardTv.setText("");
                cardTv.setBackgroundColor(R.color.black);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(card);
                }
            });
        }
    }

    interface onCardClick{
        void onItemClick(Card<String>card);
    }
}
