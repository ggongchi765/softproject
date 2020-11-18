package com.example.softproject;

import android.content.Intent;
import android.os.Bundle;


import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class ShopActivity  extends AppCompatActivity {


    ViewPager viewPager;
    Button b_toy;
    Button b_snack;
    Button b_extra;
    ImageView btn_chart;

    private class pagerAdpater extends FragmentStatePagerAdapter
    {
        public pagerAdpater(android.support.v4.app.FragmentManager fm){
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position){
            switch (position)
            {
                case 0:
                    return new SnackFragment();
                case 1:
                    return new ToyFragment();
                case 2:
                    return new ExtraFragment();

                    default:
                        return null;
            }
        }
        @Override
        public int getCount()
        {
            return 3;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        viewPager=(ViewPager)findViewById(R.id.shopPager);
        b_toy=(Button)findViewById(R.id.toy__btn);
        b_snack=(Button)findViewById(R.id.snack_btn);
        b_extra=(Button)findViewById(R.id.extra_btn);

        viewPager.setAdapter(new pagerAdpater(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        b_snack.setOnClickListener(movePageListener);
        b_snack.setTag(0);
        b_toy.setOnClickListener(movePageListener);
        b_toy.setTag(1);
        b_extra.setOnClickListener(movePageListener);
        b_extra.setTag(2);

        btn_chart=(ImageView)findViewById(R.id.btn_chart);
        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ShopActivity.this,ChartActivity.class);
                startActivity(intent);
            }
        });
    }

    View.OnClickListener movePageListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int tag =(int) v.getTag();
            viewPager.setCurrentItem(tag);
        }
    };

}
