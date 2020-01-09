package com.example.badabaseandroid;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class StroreData {
    private static StroreData instance;
    private static Context ctx;
    private static final String SHARED_REF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_ID = "userid";


    private StroreData(Context context) {
        ctx = context;
    }

    public static synchronized StroreData getInstance(Context context) {
        if (instance == null) {
            instance = new StroreData(context);
        }
        return instance;
    }

    public boolean userLogin(int id, String userName, String email){

        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL,email);
        editor.putString(KEY_USERNAME, userName);

        editor.apply();
        return true;
    }

    public boolean isLgoin(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString(KEY_USERNAME,null) != null){
            return true;
        }
        return false;
    }

    public boolean logOut(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_REF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
}

