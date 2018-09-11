package com.example.imagepickerdb;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class Database extends SQLiteOpenHelper {

	static String DB = "db_person";
	static String PERSON = "tbl_person";
	
	public Database(Context context) {
		super(context, DB, null, 1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		 
		String sql="CREATE TABLE "+PERSON+"(id integer primary key autoincrement, name varchar(25), image varchar(50))";
		db.execSQL(sql);
		 
	}
	
	public long addPerson(String name, Uri image){
		SQLiteDatabase db = this.getWritableDatabase();
			ContentValues cv = new ContentValues();
				cv.put("name", name);
				cv.put("image", image.toString());
			return db.insert(PERSON, null, cv);
	}
	
	public ArrayList<Person> getAll(){
		SQLiteDatabase db = this.getWritableDatabase();
			ArrayList<Person> list = new ArrayList<Person>();
			Cursor c = db.query(PERSON, null, null, null, null, null, null);
				
				c.moveToFirst();
				while(!c.isAfterLast()){
					String name = c.getString(c.getColumnIndex("name"));
					String image = c.getString(c.getColumnIndex("image"));
					
					Uri uriImage = Uri.parse(image);
					Person p = new Person(uriImage, name);
					list.add(p);
					c.moveToNext();
					
				}
				return list;
	}
	
	public int countRecord(){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.query(PERSON, null, null, null, null, null, null);
		return c.getCount();
	}
	
	public long updatePerson(String name, Uri image){
		SQLiteDatabase db = this.getWritableDatabase();
			ContentValues cv = new ContentValues();
				cv.put("name", name);
				cv.put("image", image.toString());
			return db.update(PERSON,cv,"name=?",new String[]{name});
	}
	
	/*public long updatePerson(String name, Uri image){
		SQLiteDatabase db = this.getWritableDatabase();
			int id = 5;
			ContentValues cv = new ContentValues();
				cv.put("name", name);
				cv.put("image", image.toString());
			//return db.update(PERSON,cv,"id=?",new String[]{id});
			return db.update(PERSON,cv,"id="+id,null);
	}*/
	
	public int deletePerson(String name){
		SQLiteDatabase db = this.getWritableDatabase();
		return db.delete(PERSON,"name=?",new String[]{name});
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
