
package com.example.softproject;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.ListFragment;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RelativeLayout;

public class ToyFragment extends ListFragment {
    ListViewAdapter adapter;
    public ToyFragment()
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
        adapter.addItem(new Item(6000,"낚시대", ContextCompat.getDrawable(getActivity(),R.drawable.fish)));
        adapter.addItem(new Item(1500,"공",ContextCompat.getDrawable(getActivity(),R.drawable.ball)));
        adapter.addItem(new Item(2000,"캣닢 쿠션",ContextCompat.getDrawable(getActivity(),R.drawable.catnip)));
        adapter.addItem(new Item(1000,"나무 막대기",ContextCompat.getDrawable(getActivity(),R.drawable.ddabi)));

        return  super.onCreateView(inflater,viewGroup,bundle);

    }

}
