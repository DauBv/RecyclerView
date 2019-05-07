package com.recyclerview.header.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.recyclerview.header.R;
import com.recyclerview.header.model.ItemContent;

import java.util.List;

/**
 * @author buivandau
 */
public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String DEBUG = CustomRecyclerViewAdapter.class.getSimpleName();
    private List<ItemContent> listContent;
    private int TYPE_HEADER = 0;
    private int TYPE_ITEM = 1;

    /**
     *
     * Constructor CustomRecyclerViewAdapter
     * @param listContent
     */
    public CustomRecyclerViewAdapter(List<ItemContent> listContent) {
        this.listContent = listContent;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout, viewGroup, false);
            return new HeaderViewHolder(view);
        } else if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
            return new ItemViewHolder(view);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ItemContent itemContent = listContent.get(i);
        if (viewHolder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) viewHolder).headerTitle.setText(itemContent.getContents());
        } else if (viewHolder instanceof ItemViewHolder) {
            ((ItemViewHolder) viewHolder) .itemContent.setText(itemContent.getContents());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0 || position == 5;
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }
}
