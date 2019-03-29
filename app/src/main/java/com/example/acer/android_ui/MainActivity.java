package com.example.acer.android_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_1=(Button)findViewById(R.id.button1);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮响应函数中添加如下两句话就ok了
                Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,ListviewActivity.class);
                startActivity(intent);
            }
        });
        Button button_2=(Button)findViewById(R.id.button2);
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮响应函数中添加如下两句话就ok了
                Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,AlertdialogActivity.class);
                startActivity(intent);
            }
        });
        Button button_3=(Button)findViewById(R.id.button3);
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮响应函数中添加如下两句话就ok了
                Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,XmlMenuActivity.class);
                startActivity(intent);
            }
        });
        Button button_4=(Button)findViewById(R.id.button4);
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //在按钮响应函数中添加如下两句话就ok了
                Intent intent=new Intent(com.example.acer.android_ui.MainActivity.this,ActionModeActivity.class);
                startActivity(intent);
            }
        });
    }
}
