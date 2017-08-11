package com.ytc.agendaafrica.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ytc.agendaafrica.AgendaDetails;
import com.ytc.agendaafrica.R;
import com.ytc.agendaafrica.models.agenda;

import java.util.List;

public class GoogleCardSingleAgendaAdapter extends ArrayAdapter<agenda>
		implements OnClickListener {

	private LayoutInflater mInflater;
	Activity context;

	public GoogleCardSingleAgendaAdapter(Activity context, List<agenda> items) {
		super(context, 0, items);
		this.context=context;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(
					R.layout.list_item_google_cards_prayer, parent, false);
			holder = new ViewHolder();

			holder.categoryName = (TextView) convertView
					.findViewById(R.id.list_item_google_cards_travel_title_prayer);
			holder.aspirationcontainer = (LinearLayout) convertView
					.findViewById(R.id.aspirationcontainer);

			convertView.setTag(holder);

			final agenda item = getItem(position);

			holder.categoryName.setText(item.getAgendatitle());
//			holder.text.setText(item.getAgendadetail());

			holder.aspirationcontainer.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					Intent intent=new Intent(context, AgendaDetails.class);
					//add data to the Intent object
					intent.putExtra("agendaid", item.getId());
					intent.putExtra("agendaname", item.getAgendatitle());
					intent.putExtra("description", item.getAgendadetail());

					//start the second activity
					context.startActivity(intent);

				}
			});

		} else {
			holder = (ViewHolder) convertView.getTag();
		}



		return convertView;
	}

	private static class ViewHolder {

		public TextView categoryName;
		public LinearLayout aspirationcontainer;
		public TextView text;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int possition = (Integer) v.getTag();

	}
}
