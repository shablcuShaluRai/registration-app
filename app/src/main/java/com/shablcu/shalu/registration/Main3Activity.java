package com.shablcu.shalu.registration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button btlogout;
    EditText etname,etage,etusername;
    UserlocalStore userlocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        etname=(EditText)findViewById(R.id.etname);
        etage=(EditText)findViewById(R.id.etage);
        etusername=(EditText)findViewById(R.id.etusername);
        btlogout=(Button)findViewById(R.id.btlogout);
        btlogout.setOnClickListener(this);
        userlocalStore=new UserlocalStore(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate()==true) {
            displayuserdetails();
        }
    }
    public boolean authenticate(){
        return userlocalStore.getuserloggedIn();
    }


    private void displayuserdetails(){
        User user=userlocalStore.getloggedInuser();
        etusername.setText(user.username);
        etname.setText(user.name);
         etage.setText(user.age + "");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btlogout:
                userlocalStore.clearuserdata();
                userlocalStore.setuserloggedIn(false);

                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
