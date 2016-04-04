package com.example.loadmore;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/4/5.
 */
public class ListViewActivity extends Activity {
	ListView listView;
	ListViewAdapter adapter;
	RefreshLayout refreshLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		listView = (ListView) findViewById(R.id.listview);
		refreshLayout = (RefreshLayout) findViewById(R.id.refreshlauout);
		adapter = new ListViewAdapter(this);
		listView.setAdapter(adapter);
		// 下拉刷新
		refreshLayout
				.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
					@Override
					public void onRefresh() {
						listView.postDelayed(new Runnable() {
							@Override
							public void run() {
								adapter.refresh();
								refreshLayout.setRefreshing(false);
							}
						}, 100);
					}
				});
		// 上拉加载
		refreshLayout.setOnLoadListener(new RefreshLayout.OnLoadListener() {
			@Override
			public void onLoad() {
				listView.postDelayed(new Runnable() {
					@Override
					public void run() {
						adapter.loadMore();
						refreshLayout.setLoading(false);
					}
				}, 1000);

			}
		});

	}
}
