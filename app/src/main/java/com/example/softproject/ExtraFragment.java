
package com.example.softproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ExtraFragment extends ListFragment {
    ListViewAdapter adapter;
    public ExtraFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        RelativeLayout layout =(RelativeLayout) inflater.inflate(R.layout.toy,viewGroup,false);

        adapter = new ListViewAdapter();
        setListAdapter(adapter);
        adapter.addItem(new Item(15000,"모래", ContextCompat.getDrawable(getActivity(),R.drawable.sand)));
        adapter.addItem(new Item(6000,"브러쉬",ContextCompat.getDrawable(getActivity(),R.drawable.brush)));
        adapter.addItem(new Item(12000,"칫솔",ContextCompat.getDrawable(getActivity(),R.drawable.tooth)));
        adapter.addItem(new Item(20000,"사료",ContextCompat.getDrawable(getActivity(),R.drawable.rice)));

        return  super.onCreateView(inflater,viewGroup,bundle);

    }

}

