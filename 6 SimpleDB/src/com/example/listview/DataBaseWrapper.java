package com.example.listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseWrapper extends SQLiteOpenHelper {
	
	private static final String DATABASE_CREATE = "create table CUSTOMERS( ID integer primary key autoincrement, NAME text not null) ";
	SQLiteDatabase db;
	
	public DataBaseWrapper(Context context) {
		
		        super(context, "customers.db", null, 1);
		
		    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		this.db = db;
		
				 db.execSQL(DATABASE_CREATE);

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS CUSTOMERS");
		onCreate(db);
		
	}
	
	

}
