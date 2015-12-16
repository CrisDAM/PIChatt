package com.example.cris.pichat;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by 21438547 on 16/12/2015.
 */
public class PIChat extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);

        Parse.initialize(this);




    }
}
