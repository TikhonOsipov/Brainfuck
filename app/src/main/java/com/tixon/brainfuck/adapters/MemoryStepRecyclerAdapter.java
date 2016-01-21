package com.tixon.brainfuck.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tixon.brainfuck.Interpreter.Memory;
import com.tixon.brainfuck.R;

/**
 * Created by tikhon on 21/01/16.
 */
public class MemoryStepRecyclerAdapter extends RecyclerView.Adapter<MemoryStepRecyclerAdapter.ViewHolder> {

    Memory memory;

    public MemoryStepRecyclerAdapter(Memory memory) {
        this.memory = memory;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.memory_recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvValue.setText(String.valueOf(memory.getData().get(position)));
        holder.setColor(position == memory.getDataPointer());
    }

    @Override
    public int getItemCount() {
        return memory.getData().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvValue;
        RelativeLayout frame;

        public ViewHolder(View itemView) {
            super(itemView);
            frame = (RelativeLayout) itemView.findViewById(R.id.recycler_item_frame);
            tvValue = (TextView) itemView.findViewById(R.id.recycler_item_tv_value);
        }

        public void setColor(boolean isSelected) {
            frame.setBackgroundColor(isSelected
                    ? Color.parseColor("#C5CAE9")
                    : Color.parseColor("#00000000"));
        }
    }
}
