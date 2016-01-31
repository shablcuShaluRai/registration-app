package com.shablcu.shalu.registration;


import android.content.Context;
import android.content.SharedPreferences;

public class UserlocalStore {

    public  static final String SP_Name="UserDeatails";
    SharedPreferences UserLocalDatbase;
    public UserlocalStore(Context context){
        UserLocalDatbase=context.getSharedPreferences(SP_Name,0);

    }


    public void storeUserData(User user){
        SharedPreferences.Editor spEditor=UserLocalDatbase.edit();
        spEditor.putString("name", user.name);
        spEditor.putInt("age", user.age);
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.commit();

    }

    public User getloggedInuser(){
        String name=UserLocalDatbase.getString("name", "");
        int age=UserLocalDatbase.getInt("age", -1);
        String username=UserLocalDatbase.getString("username", "");
        String password=UserLocalDatbase.getString("password","");

        User storeduser=new User(name,age,username,password);
        return storeduser;
            }


    public void setuserloggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor=UserLocalDatbase.edit();
        spEditor.putBoolean("loggeedIn",loggedIn);
        spEditor.commit();

    }
    public boolean getuserloggedIn(){
        if (UserLocalDatbase.getBoolean("loggedIn",false)==true){
            return true;
        }else{
            return false;
        }
    }

    public void clearuserdata(){
        SharedPreferences.Editor spEditor=UserLocalDatbase.edit();
        spEditor.clear();
        spEditor.commit();

    }
}
