package com.shablcu.shalu.registration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
     Button btregister;
    EditText etname,etage,etusername,etpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etname=(EditText)findViewById(R.id.etname);
        etage=(EditText)findViewById(R.id.etage);
        etusername=(EditText)findViewById(R.id.etusername);
        etpassword=(EditText)findViewById(R.id.etpassword);
        btregister=(Button)findViewById(R.id.btregister);
        btregister.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btregister:
            String name=etname.getText().toString();
                String username=etusername.getText().toString();
                String password=etpassword.getText().toString();
                int age=Integer.parseInt(etage.getText().toString());
                User registerdata=new User(name,age,username,password);
                break;
        }
    }
}
