package com.example.softproject;


import android.graphics.drawable.Drawable;

public class Item  { // 파는 물건 class
    private int cost;
    private String name;
    private Drawable image;
    private int size;

    public Item(int cost,String name,Drawable image) {
        this.cost=cost;
        this.image=image;
        this.name=name;
        this.size=0;

    }

    public Drawable getImage_name() {
        return image;
    }

    public String getName() {
        return name;
    }


    public int getCost() {
        return cost;
    }

    public int getSize(){return  size;}

    public void Plus_size(){size++;}
    public void Minus_size(){
        if(size >0)
            size--;
    }
    public void Zero(){
        size=0;
            }
    public void setSize(int num){
        size=num;
    }
}
