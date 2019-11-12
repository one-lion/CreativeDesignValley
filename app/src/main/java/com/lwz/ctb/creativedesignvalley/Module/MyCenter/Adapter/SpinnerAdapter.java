package com.lwz.ctb.creativedesignvalley.Module.MyCenter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lwz.ctb.creativedesignvalley.R;

import java.util.ArrayList;

public class SpinnerAdapter extends BaseAdapter {
   private Context context;
   private ArrayList<String> list;

   public SpinnerAdapter(Context context, ArrayList<String> list){
       this.context=context;
       this.list=list;
   }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder;
       if(convertView==null){
           convertView= LayoutInflater.from(context).inflate(R.layout.choice_item,parent,false);
           holder=new ViewHolder();
           holder.itemText=(TextView)convertView.findViewById(R.id.tv_choice_item);
           convertView.setTag(holder);
       }else{
           holder=(ViewHolder)convertView.getTag();
       }
        holder.itemText.setText(list.get(position));
        return convertView;
    }

    class ViewHolder{
       TextView itemText;
    }

}
