package com.example.loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/4/5.
 */
public class ListViewAdapter extends BaseAdapter {
	int count = 5;
	Context mContext;
	public ListViewAdapter(Context context) {
		mContext = context;
	}
	@Override
	public int getCount() {
		return count;
	}
	public void loadMore() {
		count += 5;
		notifyDataSetChanged();
	}
	public void refresh() {
		count = 5;
		notifyDataSetChanged();
	}
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(mContext).inflate(
				R.layout.item_recyclerview, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(R.drawable.ic_launcher);
		return view;
	}
}
