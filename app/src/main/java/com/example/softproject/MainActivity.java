package com.example.softproject;

import android.content.Intent;
import android.database.Cursor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Login log;
    private EditText etId;
    private EditText etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        log=new Login();
        log.logindb=log.init_database();
        log.init_tables();


        //id ,password 설정
        etId = (EditText) findViewById(R.id.input_id);
        etPassword = (EditText) findViewById(R.id.input_password);

    }

    // 회원가입 화면으로 이동.
    public void onRegister(View view) {
        Intent intent =new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    //접속 시도
    public void onMain(View view)
    {


        String password = etPassword.getText().toString();
        String sid = etId.getText().toString();


        if(password.length()==0)
            Toast.makeText(MainActivity.this, "비밀번호 입력하세요", Toast.LENGTH_SHORT).show();
        else if(sid.length()==0)
            Toast.makeText(MainActivity.this, "ID 입력하세요", Toast.LENGTH_SHORT).show();
        else{
            boolean check=false;
            Cursor cursor=log.logindb.rawQuery("SELECT * FROM CONTACT_T",null);
            while(cursor.moveToNext()){
                if(sid.equals(cursor.getString(0)))
                 if(password.equals(cursor.getString(1)))//로그인 성공
                 {
                     check=true;
                     Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                     Intent intent =new Intent(this,ShopActivity.class);
                     startActivity(intent);
                 }
                else
                 {
                     Toast.makeText(MainActivity.this, "비밀번호가 틀렸습니다.", Toast.LENGTH_SHORT).show();
                 }
            }

            if(!check)// ID 존재하지 않는다.
                Toast.makeText(MainActivity.this, "존재하지 않은 ID.", Toast.LENGTH_SHORT).show();


         }


    }
}
