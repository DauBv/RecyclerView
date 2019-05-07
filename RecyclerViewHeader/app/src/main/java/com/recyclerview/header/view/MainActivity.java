package com.recyclerview.header.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.recyclerview.header.R;
import com.recyclerview.header.model.ItemContent;
import com.recyclerview.header.presenter.CustomRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author buivandau
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rcv_header)
    RecyclerView addHeaderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        addHeaderRecyclerView.setLayoutManager(linearLayoutManager);
        addHeaderRecyclerView.setHasFixedSize(true);
        CustomRecyclerViewAdapter customAdapter = new CustomRecyclerViewAdapter(getDataSource());
        addHeaderRecyclerView.setAdapter(customAdapter);
    }

    /**
     * Function get DataSource
     * @return List<ItemContent>
     */
    private List<ItemContent> getDataSource() {
        List<ItemContent> data = new ArrayList<>();
        data.add(new ItemContent("First Header"));
        data.add(new ItemContent("This is the item content in the 1 position"));
        data.add(new ItemContent("This is the item content in the 2 position"));
        data.add(new ItemContent("This is the item content in the 3 position"));
        data.add(new ItemContent("This is the item content in the 4 position"));
        data.add(new ItemContent("Two Header"));
        data.add(new ItemContent("This is the item content in the 1 position"));
        data.add(new ItemContent("This is the item content in the 2 position"));
        data.add(new ItemContent("This is the item content in the 3 position"));
        data.add(new ItemContent("This is the item content in the 4 position"));
        data.add(new ItemContent("This is the item content in the 5 position"));
        return data;
    }
}
