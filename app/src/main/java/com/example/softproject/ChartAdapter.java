package com.example.softproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChartAdapter   extends BaseAdapter { // 장바구니 list Adapeter
    Context context;
    ArrayList<Item> itemArrayList;
    Chart chart;
    TextView name;
    TextView cost;
    TextView size;
    TextView total;
    ImageView imageView;
    Button bt_delete;
    public ChartAdapter(Context context, ArrayList<Item> list)
    {
        this.context=context;
        this.itemArrayList=list;
        chart= new Chart();
    }

    @Override
    public int getCount() {
        return this.itemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemArrayList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.chart_item,null);
            name=(TextView)convertView.findViewById(R.id.chart_item_name);
            size=(TextView)convertView.findViewById(R.id.chart_item_size);
            cost=(TextView)convertView.findViewById(R.id.chart_item_cost);
            total=(TextView)convertView.findViewById(R.id.chart_item_total);
            imageView=(ImageView)convertView.findViewById(R.id.chart_item_image);
            bt_delete=(Button)convertView.findViewById(R.id.chart_item_delete);

        }
        name.setText(itemArrayList.get(position).getName());
        size.setText(String.valueOf(itemArrayList.get(position).getSize()));
        cost.setText(String.valueOf(itemArrayList.get(position).getCost()));
        total.setText(String.valueOf(itemArrayList.get(position).getCost()*itemArrayList.get(position).getSize()));
        imageView.setImageDrawable(itemArrayList.get(position).getImage_name());

        bt_delete.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                chart.Delete(itemArrayList.get(position));
                total.setText(String.valueOf(chart.getTot()));
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


}
