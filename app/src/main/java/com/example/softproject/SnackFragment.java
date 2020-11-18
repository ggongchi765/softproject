
package com.example.softproject;

        import android.os.Bundle;
        import android.support.constraint.ConstraintLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.ListFragment;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;
        import android.widget.RelativeLayout;

        import java.util.List;

public class SnackFragment extends ListFragment {
    ListViewAdapter adapter;
    public SnackFragment()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle)
    {
        RelativeLayout layout =(RelativeLayout) inflater.inflate(R.layout.snack,viewGroup,false);
        adapter = new ListViewAdapter();
        setListAdapter(adapter);
        adapter.addItem(new Item(3000,"츄르", ContextCompat.getDrawable(getActivity(),R.drawable.chao)));
        adapter.addItem(new Item(4500,"탬패스트",ContextCompat.getDrawable(getActivity(),R.drawable.temptation)));
        adapter.addItem(new Item(1000,"통조림",ContextCompat.getDrawable(getActivity(),R.drawable.can)));
        adapter.addItem(new Item(6000,"그리니즈",ContextCompat.getDrawable(getActivity(),R.drawable.green)));
        adapter.addItem(new Item(2500,"크리스피",ContextCompat.getDrawable(getActivity(),R.drawable.kiss)));
        adapter.addItem(new Item(6000,"게맛살",ContextCompat.getDrawable(getActivity(),R.drawable.slice)));
        adapter.addItem(new Item(1200,"사탕",ContextCompat.getDrawable(getActivity(),R.drawable.candy)));

       return  super.onCreateView(inflater,viewGroup,bundle);

    }

    @Override
    public void onListItemClick(ListView listView, View view, int position ,long id)
    {
        Item item =(Item)listView.getItemAtPosition(position);

    }


}