package com.example.loadmore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MyActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {
    SwipeRefreshLayout mSwipeRefreshWidget;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    int lastVisibleItem;
    ImageViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_recyclerview);
        mSwipeRefreshWidget = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        mSwipeRefreshWidget.setOnRefreshListener(this);
        adapter = new ImageViewAdapter(this);
        mLayoutManager = new GridLayoutManager(this, 5);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
        mSwipeRefreshWidget.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(RecyclerView recyclerView,
                                             int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItem + 1 == adapter.getItemCount()) {
                    mSwipeRefreshWidget.setRefreshing(true);


                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }

        });

    }

    @Override
    public void onRefresh() {
        Log.d("scofanfan", "onRefresh");
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.loadMore();
                mSwipeRefreshWidget.setRefreshing(false);
            }
        }, 1000);
    }
}
