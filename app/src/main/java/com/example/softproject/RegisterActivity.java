package com.example.softproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class RegisterActivity  extends Activity {

    private EditText etId;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    Login login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etId = (EditText) findViewById(R.id.registerid);
        etPassword = (EditText) findViewById(R.id.registerPW);
        etPasswordConfirm = (EditText) findViewById(R.id.registerPWC);

        etId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { // id가 입력 완료 되었을때 중복을 확인해야된다.
                boolean tmp=true;
                Cursor cursor=login.logindb.rawQuery("SELECT * FROM CONTACT_T",null);
                while(cursor.moveToNext()){
                    if(etId.getText().toString().equals(cursor.getString(0)))//id 중복
                    {
                        tmp=false;
                        etId.setBackgroundColor(RED);
                        Toast.makeText(RegisterActivity.this, "ID가 중복 됩니다.", Toast.LENGTH_SHORT).show();
                }}
                if(tmp==true)
                    etId.setBackgroundColor(GREEN);
            }
        });

    }

    public void tryRegister(View view) {
        // 회원 등록을 시도한다.
         String password = etPassword.getText().toString();
        String sid = etId.getText().toString();

        String confirm = etPasswordConfirm.getText().toString();


        if (sid.length() == 0) {
            Toast.makeText(RegisterActivity.this, "ID를 입력해주세요.", Toast.LENGTH_SHORT).show();
        } else if (password.length() == 0) {
            Toast.makeText(RegisterActivity.this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirm)) {
            etPassword.setBackgroundColor(RED);
            Toast.makeText(RegisterActivity.this, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(RegisterActivity.this, "회원 등록 완료", Toast.LENGTH_SHORT).show();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(login.logindb != null){

                        String sqlInsert = "INSERT INTO CONTACT_T " +
                                "(ID, PASSWORD) VALUES (" +
                                "'" + etId.getText().toString() + "'," +
                                "'" + etPassword.getText().toString()  + "')" ;
                        login.logindb.execSQL(sqlInsert);
                    }

                    finish();
                }
            }, 1000);


        }

    }


}