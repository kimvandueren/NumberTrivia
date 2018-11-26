package com.example.kim.numbertrivia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    public List<TriviaItem> listTriviaItem;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView numberText;
        public TextView triviaText;
        public View view;

        public ViewHolder(View itemView) {
            super(itemView);
            numberText = itemView.findViewById(R.id.numberText);
            triviaText = itemView.findViewById(R.id.triviaText);
            view = itemView;
        }
    }

    public RecyclerViewAdapter(Context context, List<TriviaItem> listTriviaItem) {
        this.context = context;
        this.listTriviaItem = listTriviaItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final TriviaItem triviaItem = listTriviaItem.get(position);
        holder.numberText.setText(triviaItem.getNumber());
        holder.triviaText.setText(triviaItem.getText());
    }

    @Override
    public int getItemCount() {
        return listTriviaItem.size();
    }
}
