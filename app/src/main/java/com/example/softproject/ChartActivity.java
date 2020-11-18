package com.example.softproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChartActivity extends AppCompatActivity {
    ListView listView;
    ChartAdapter chartAdapter;
    Chart chart;
    TextView total;
    Button complete;
    @Override
    protected void onCreate(Bundle savedInstanceState){ //장바구니 화면을 보여줌

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        listView=(ListView)findViewById(R.id.chart_list);
        complete=(Button)findViewById(R.id.btn_end);
        chart=new Chart();
        chartAdapter=new ChartAdapter(ChartActivity.this,chart.getItemArrayList());
        listView.setAdapter(chartAdapter);

        total=(TextView)findViewById(R.id.total_cost_result);
        total.setText(String.valueOf(chart.getTot()));



    }

    public void End(View v){
       AlertDialog.Builder alert =new AlertDialog.Builder(this);
       alert.setTitle("현금 결제");

       alert.setMessage("총 금액은 "+chart.getTot()+"원 입니다. 244-910515-85107 박시연으로 입금해주세요")
               .setCancelable(false)
               .setPositiveButton("확인",
                       new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               chart.Delete();

                               Intent intent=getIntent();
                               finish();
                               startActivity(intent);
                           }
                       }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
           }
       });

       AlertDialog alertDialog=alert.create();
       alertDialog.show();
    }


}
