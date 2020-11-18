package com.example.softproject;

import java.util.ArrayList;

public class Chart {// 장바구니를 관리한다.
    private static ArrayList<Item> itemArrayList=new ArrayList<Item>() ;
    private static int tot=0;

    public void AddItem(Item tmp)
    {
        for(int i=0; i<itemArrayList.size();i++)
            if(itemArrayList.get(i).getName().compareTo(tmp.getName())==0)
            {
                tmp.setSize(tmp.getSize()+itemArrayList.get(i).getSize()-1);
                itemArrayList.remove(i);

            }
        itemArrayList.add(tmp);
        tot=tot+tmp.getCost()*tmp.getSize();
    }
    public ArrayList<Item> getItemArrayList()
    {
        return itemArrayList;
    }

    public int getTot() {
        return tot;
    }
    public void Delete(Item tmp)
    {
        for(int i=0; i<itemArrayList.size();i++)
            if(itemArrayList.get(i).getName().compareTo(tmp.getName())==0)
            {
                tot=tot-itemArrayList.get(i).getCost()*itemArrayList.get(i).getSize();
                itemArrayList.remove(i);

            }
    }
    public void Delete(int tmp)
    {
        tot=tot-itemArrayList.get(tmp).getCost()*itemArrayList.get(tmp).getSize();
           itemArrayList.remove(tmp);
    }

    public void Delete()
    {
        itemArrayList.clear();
        tot=0;
    }
}
