package com.telnor.curso.tadk.listview;

import com.androidquery.AQuery;
import com.telnor.curso.tadk.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class RowAdapter extends ArrayAdapter<String>{
	
	AQuery aq;
	
	public RowAdapter(Context context){
		super(context,R.layout.listview_generico,R.id.lv_generico_contenido);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View  view =  super.getView(position, convertView, parent);
		
		aq = new AQuery(view);
		aq.id(R.id.lv_generico_contenido).text(getItem(position));
		
		return view;
	}
	
	
}
