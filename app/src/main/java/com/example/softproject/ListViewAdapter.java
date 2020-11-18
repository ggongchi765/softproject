package com.example.softproject;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

// 등록된 물건을 보여주는 listveiw를 위한 Adapter
public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Item> itemArrayList =new ArrayList<Item>();
    Chart chart=new Chart();
    Context con;
    public ListViewAdapter()
    {}

    @Override
    public  int getCount(){
        return itemArrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        final int pos=position;
        final Context context=parent.getContext();

        if(convertView==null)
        {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item,parent,false);
            con=context;
        }
        // List view에 넣을 내용 연결
        TextView textname=(TextView) convertView.findViewById(R.id.item_name);
        ImageView itemimage=(ImageView) convertView.findViewById(R.id.item_img);
        TextView textcost=(TextView)convertView.findViewById(R.id.item_cost);
        TextView text_size=(TextView)convertView.findViewById(R.id.item_size);

        Button btnplus=(Button) convertView.findViewById(R.id.plus);
        Button btnminus=(Button)convertView.findViewById(R.id.minus);
        Button btnAdd=(Button) convertView.findViewById(R.id.btn_add);

        btnminus.setTag(position);
        btnplus.setTag(position);
        btnAdd.setTag(position);
        btnplus.setOnClickListener(Plus); // 버튼 리스너 등록
        btnminus.setOnClickListener(Minus);
        btnAdd.setOnClickListener(Add);


        Item tmp=itemArrayList.get(pos);
        textname.setText(tmp.getName());
        itemimage.setImageDrawable(tmp.getImage_name());
        textcost.setText(String.valueOf(tmp.getCost()));
        text_size.setText(String.valueOf(tmp.getSize()));



        return convertView;

    }
    @Override
    public  long getItemId(int pos)
    {
        return pos;
    }

    @Override
    public Object getItem(int pos)
    {
        return itemArrayList.get(pos);
    }

    //Item(int cost,String name,String image_name)
    public void addItem(Item item)
    {
        Item tmp=new Item(item.getCost(),item.getName(),item.getImage_name());
        itemArrayList.add(tmp);
    }

    Button.OnClickListener Plus =new Button.OnClickListener(){ //갯수 증가

        @Override
        public  void onClick(View v)
        {
            int position =Integer.parseInt(v.getTag().toString());
            itemArrayList.get(position).Plus_size();
            notifyDataSetChanged();
        }
    };

    Button.OnClickListener Minus =new Button.OnClickListener(){ // 갯수 감소

        @Override
        public  void onClick(View v)
        {
            int position =Integer.parseInt(v.getTag().toString());
            itemArrayList.get(position).Minus_size();
            notifyDataSetChanged();
        }
    };

    Button.OnClickListener Add =new Button.OnClickListener(){

        @Override
        public  void onClick(View v)
        {
            int position =Integer.parseInt(v.getTag().toString());
            if(itemArrayList.get(position).getSize() != 0)
            { //갯수가 0이 아닐때만 장바구니에 추가한다.
                chart.AddItem(itemArrayList.get(position));

            //  itemArrayList.get(position).Zero();

                notifyDataSetChanged();

              Toast.makeText(con,"장바구니에 추가 되었습니다.",Toast.LENGTH_SHORT).show();

            }
        }
    };
}
