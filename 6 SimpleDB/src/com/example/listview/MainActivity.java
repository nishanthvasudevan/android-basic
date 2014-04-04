package com.example.listview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity {

//	static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana",
//			"Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
//			"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
			
	private DataBaseWrapper wrapper;
	
	private SQLiteDatabase database;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		
		wrapper = new DataBaseWrapper(this);
		database= wrapper.getWritableDatabase();
		addRecord("Arvind");
		addRecord("B");
		addRecord("C");
		List allrecords= getAllRecords();
		setList(allrecords);

	}
	
	public void addRecord(String name) 
	{
		ContentValues values = new ContentValues();
		values.put("NAME", name);
		database.insert("CUSTOMERS", null, values);
	}
	
	public List getAllRecords() {
		List records = new ArrayList();

		  String[] COLUMNS = { "ID", "NAME" };
		Cursor cursor = database.query("CUSTOMERS",
				COLUMNS, null, null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			String name = parseRecord(cursor);
			records.add(name);
			cursor.moveToNext();
		}

		cursor.close();
		return records;
	}
	
	private String parseRecord(Cursor cursor) {
        int  id= (cursor.getInt(0));
        String name =(cursor.getString(1));
        return name;
    }

	
	private void setList(List allrecords) {
		setListAdapter(new ArrayAdapter<String>(this, R.layout.fruit,allrecords));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			    // When clicked, show a toast with the TextView text
			    Toast.makeText(getApplicationContext(),
				((TextView) view).getText(), Toast.LENGTH_SHORT).show();
			    
			   
			}
		});
	}
	
	

}