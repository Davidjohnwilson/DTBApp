package com.davetriesballet.DTB;

import java.util.ArrayList;

import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainFirstClassChecklistFemale extends Activity {

	MyCustomAdapter dataAdapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainfirstclasschecklistfemale);

		// Generate list view from ArrayList
		displayListView();

		checkButtonClick();
	}

	private void displayListView() {

		// Array list of items
		ArrayList<DanceItem> itemList = new ArrayList<DanceItem>();
		DanceItem item = new DanceItem("Leotard", "A woman's Leotard", false);
		itemList.add(item);
		item = new DanceItem("Shoes", "A pair of ballet shoes", false);
		itemList.add(item);
		item = new DanceItem("Tights", "A pair of pink tights", false);
		itemList.add(item);
		item = new DanceItem("Skirt", "A ballet skirt", false);
		itemList.add(item);
		item = new DanceItem("Dance Journal", "A dance journal and pen", false);
		itemList.add(item);

		// create an ArrayAdaptor from the Array
		dataAdapter = new MyCustomAdapter(this, R.layout.item_info, itemList);
		ListView listView = (ListView) findViewById(R.id.listView1);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView parent, View view,
					int position, long id) {
				// When Clicked, show a toast with the TextView text
				DanceItem item = (DanceItem) parent.getItemAtPosition(position);
				Toast.makeText(getApplicationContext(),
						"Do you want to pack your " + item.getCode() + "?",
						Toast.LENGTH_LONG).show();
			}
		});
	}

	private class MyCustomAdapter extends ArrayAdapter<DanceItem> {
		private ArrayList<DanceItem> itemList;

		public MyCustomAdapter(Context context, int textViewResourceId,
				ArrayList<DanceItem> itemList) {
			super(context, textViewResourceId, itemList);
			this.itemList = new ArrayList<DanceItem>();
			this.itemList.addAll(itemList);
		}

		private class ViewHolder {
			TextView code;
			CheckBox name;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			Log.v("ConvertView", String.valueOf(position));

			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.item_info, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code);
				holder.name = (CheckBox) convertView
						.findViewById(R.id.checkBox1);
				convertView.setTag(holder);

				holder.name.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						CheckBox cb = (CheckBox) v;
						DanceItem item = (DanceItem) cb.getTag();
						Toast.makeText(getApplicationContext(),
								"You just selected " + item.getCode() + ".",
								Toast.LENGTH_LONG).show();
						item.setSelected(cb.isChecked());
					}
				});
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			DanceItem item = itemList.get(position);
			// holder.code.setText(item.getCode());
			holder.name.setText(item.getName());
			holder.name.setChecked(item.isSelected());
			holder.name.setTag(item);

			return convertView;

		}

	}

	private void checkButtonClick() {

		Button myButton = (Button) findViewById(R.id.findSelected);
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuffer responseText = new StringBuffer();
				responseText.append("The following are selected:");

				ArrayList<DanceItem> itemList = dataAdapter.itemList;
				for (int i = 0; i < itemList.size(); i++) {
					DanceItem item = itemList.get(i);
					if (item.isSelected()) {
						responseText.append("\n" + item.getCode());
					}
				}

				responseText.append("\nBut you haven't packed:");
				for (int i = 0; i < itemList.size(); i++) {
					DanceItem item = itemList.get(i);
					if (!item.isSelected()) {
						responseText.append("\n" + item.getCode());
					}
				}

				Toast.makeText(getApplicationContext(), responseText,
						Toast.LENGTH_LONG).show();
			}
		});
	}

}