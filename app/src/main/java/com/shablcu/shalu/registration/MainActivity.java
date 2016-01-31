package com.shablcu.shalu.registration;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btlogin;
    EditText etusername, etpassword;
    TextView tvregisterlink;
    UserlocalStore userlocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etusername = (EditText) findViewById(R.id.etusername);
        etpassword = (EditText) findViewById(R.id.etpassword);
        btlogin = (Button) findViewById(R.id.btlogin);
        tvregisterlink=(TextView)findViewById(R.id.tvregisterlink);
        btlogin.setOnClickListener(this);
        tvregisterlink.setOnClickListener(this);
        userlocalStore=new UserlocalStore(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btlogin:
                User user = new User(null,null);
                userlocalStore.storeUserData(user);
                userlocalStore.setuserloggedIn(true);
             break;


            case R.id.tvregisterlink:
            startActivity(new Intent(this,Main2Activity.class));

                break;
        }
    }
}


