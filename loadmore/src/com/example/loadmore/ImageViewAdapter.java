package com.example.loadmore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/4/4.
 */
public class ImageViewAdapter
		extends
			RecyclerView.Adapter<ImageViewAdapter.Holder> {

	int count = 5;
	Context mContext;
	public void loadMore() {
		count += 5;
		notifyDataSetChanged();
	}
	public ImageViewAdapter(Context mContext) {
		this.mContext = mContext;
	}

	@Override
	public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
		Holder holder = new Holder(LayoutInflater.from(mContext).inflate(
				R.layout.item_recyclerview, null));
		return holder;
	}
	@Override
	public void onBindViewHolder(Holder holder, int i) {
		holder.itemView.setBackground(mContext.getResources().getDrawable(
				R.drawable.ic_launcher));
	}

	@Override
	public int getItemCount() {
		return count;
	}

	class Holder extends RecyclerView.ViewHolder {

		ImageView imageView;
		public Holder(View itemView) {
			super(itemView);
			imageView = (ImageView) itemView.findViewById(R.id.imageview);

		}

	}
}
