package com.ytc.agendaafrica.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ytc.agendaafrica.R;
import com.ytc.agendaafrica.models.news;
import com.ytc.agendaafrica.singleDisplay;

import java.util.ArrayList;
import java.util.List;


public class GoogleCardsNewsAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private List<news> mDummyModelList;

	public GoogleCardsNewsAdapter(Context context, List<news> dummyModelList) {
		mContext = context;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mDummyModelList = dummyModelList;

	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public int getCount() {
		return mDummyModelList.size();
	}

	@Override
	public Object getItem(int position) {
		return mDummyModelList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return mDummyModelList.get(position).getId();
	}



	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;

		convertView = mInflater.inflate(
				R.layout.events_item, parent,
				false);
		holder = new ViewHolder();
		holder.itemholder = (RelativeLayout) convertView
				.findViewById(R.id.newsitemholder);
		holder.newsimage = (ImageView) convertView
				.findViewById(R.id.newsimage);
		holder.newstitle = (TextView) convertView
				.findViewById(R.id.newstitle);
		holder.newsdetails = (TextView) convertView
				.findViewById(R.id.newsdetails);
		holder.newsdatatime = (TextView) convertView
				.findViewById(R.id.newsdatatime);
		holder.newsauthor = (TextView) convertView
				.findViewById(R.id.newsauthor);
		holder.newslocation = (TextView) convertView
				.findViewById(R.id.newslocation);

		convertView.setTag(holder);


		final news dm= mDummyModelList.get(position);

		String eventurl = dm.getNewsimg();
		Glide.with(mContext)
				.load(eventurl)
				.asBitmap()
				.placeholder(R.mipmap.ic_launcher)
				.into(holder.newsimage);
		holder.newstitle.setText(dm.getNewstitle());
		holder.newsdatatime.setText(String.valueOf(dm.getTime()));
		holder.newsdetails.setText(dm.getNewsdetail());
		holder.newsauthor.setText(dm.getPublisher());
		// holder.travelHeader.setText(dm.getText());
		holder.newslocation.setText(dm.getLocation());
		holder.itemholder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent=new Intent(mContext, singleDisplay.class);
				//add data to the Intent object
				intent.putExtra("name", dm.getNewstitle());
				intent.putExtra("image", dm.getNewsimg());
				intent.putExtra("desc", dm.getNewsdetail());
				intent.putExtra("time", dm.getTime());
				intent.putExtra("author", dm.getPublisher());
				intent.putExtra("location", dm.getLocation());
				//start the second activity
				mContext.startActivity(intent);
			}
		});

		return convertView;

	}

	private static class ViewHolder {
		public ImageView newsimage;
		public/* Roboto */TextView newslocation;
		public/* Roboto */TextView newsdetails;
		public/* Roboto */TextView newstitle;
		public/* Roboto */TextView eventdate;
		public/* Fontello */TextView newsdatatime;
		public/* Fontello */TextView eventtime;
		public/* Fontello */TextView newsauthor;
		public RelativeLayout itemholder;
	}




	public void remove(int position) {
		mDummyModelList.remove(position);
	}
}
