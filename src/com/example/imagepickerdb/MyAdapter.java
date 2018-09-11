package com.example.imagepickerdb;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	
	Context context;
	ArrayList<Person> list;
	LayoutInflater inflater;
	
	public MyAdapter(Context context, ArrayList<Person> list) {
		super();
		this.context = context;
		this.list = list;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		PersonView pv = null;
		if(arg1 == null){
			arg1=inflater.inflate(R.layout.itemlayout,null);
			pv=new PersonView();
			pv.iv=(ImageView) arg1.findViewById(R.id.imageView1);
			pv.tv=(TextView) arg1.findViewById(R.id.textView1);
			arg1.setTag(pv);
		}else pv=(PersonView) arg1.getTag();
		pv.iv.setImageURI(list.get(arg0).getImage());
		pv.tv.setText(list.get(arg0).getName());
		
		return arg1;
	}

	
	static class PersonView{
		ImageView iv;
		TextView tv;
	}
	
	
}
