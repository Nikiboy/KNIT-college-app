package com.knit;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ButtonAdapter extends ArrayAdapter<Item> {
	Context context;
	int layoutResourceId;
	ArrayList<Item> objects = new ArrayList<Item>();

	public ButtonAdapter(Context context, int layoutResourceId,
			ArrayList<Item> objects) {
		super(context, layoutResourceId, objects);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.objects = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View btn = convertView;
		RecordHolder holder = null;

		if (btn == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			btn = inflater.inflate(layoutResourceId, parent, false);

			holder = new RecordHolder();
			holder.txtTitle = (TextView) btn.findViewById(R.id.bottom_text);
			holder.imageItem = (ImageView) btn.findViewById(R.id.image_icon);
			btn.setTag(holder);
		} else {
			holder = (RecordHolder) btn.getTag();
		}

		Item item = objects.get(position);
		holder.txtTitle.setText(item.getTitle());
		holder.imageItem.setImageBitmap(item.getImage());
		return btn;

	}

	static class RecordHolder {
		TextView txtTitle;
		ImageView imageItem;

	}


}
