package com.recyclerview.header.presenter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.recyclerview.header.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author buivandau
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.header_id)
    TextView headerTitle;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
