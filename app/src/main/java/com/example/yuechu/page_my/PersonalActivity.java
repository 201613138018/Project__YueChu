package com.example.yuechu.page_my;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuechu.R;

public class PersonalActivity extends Activity {
    private TextView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        menu=(TextView) findViewById(R.id.foodmenu);
        Button daily=(Button) findViewById(R.id.daily);
        Button attention=(Button) findViewById(R.id.attention);
        Button btn1=(Button) findViewById(R.id.button1);
        Button btn2=(Button) findViewById(R.id.button2);
        LinearLayout L1=(LinearLayout) findViewById(R.id.Linear1);
        LinearLayout L2=(LinearLayout) findViewById(R.id.Linear2);
        LinearLayout L3=(LinearLayout) findViewById(R.id.Linear3);
        LinearLayout L4=(LinearLayout) findViewById(R.id.Linear4);
        LinearLayout L5=(LinearLayout) findViewById(R.id.Linear5);
        LinearLayout L6=(LinearLayout) findViewById(R.id.Linear6);
        LinearLayout L7=(LinearLayout) findViewById(R.id.Linear7);
        LinearLayout L8=(LinearLayout) findViewById(R.id.Linear8);
        LinearLayout L9=(LinearLayout) findViewById(R.id.Linear9);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.foodmenu:JumptoMenu();break;
                    case R.id.daily:JumptoMenu();break;
                    case R.id.attention:JumptoCare();break;
                    case R.id.button1:Toast();break;
                    case R.id.button2:Toast();break;
                    case R.id.Linear1:Toast();break;
                    case R.id.Linear2:Toast();break;
                    case R.id.Linear3:Toast();break;
                    case R.id.Linear4:Toast();break;
                    case R.id.Linear5:Toast();break;
                    case R.id.Linear6:Toast();break;
                    case R.id.Linear7:Toast();break;
                    case R.id.Linear8:Toast();break;
                    case R.id.Linear9:Toast();break;
                }
            }
        };

        menu.setOnClickListener(listener);
        daily.setOnClickListener(listener);
        attention.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        L1.setOnClickListener(listener);
        L2.setOnClickListener(listener);
        L3.setOnClickListener(listener);
        L4.setOnClickListener(listener);
        L5.setOnClickListener(listener);
        L6.setOnClickListener(listener);
        L7.setOnClickListener(listener);
        L8.setOnClickListener(listener);
        L9.setOnClickListener(listener);
    }

    public void JumptoMenu()
    {
        Intent intent=new Intent(PersonalActivity.this,MenuActivity.class);
        startActivity(intent);
    }

    public void JumptoCare()
    {
        Intent intent=new Intent(PersonalActivity.this,CareActivity.class);
        startActivity(intent);
    }

    public void Toast()
    {
        Toast.makeText(PersonalActivity.this,"功能研发中",Toast.LENGTH_SHORT).show();
    }
}
