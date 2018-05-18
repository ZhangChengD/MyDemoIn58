package com.zc.viewconstructor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zc.mydemoin58.R;

public class ViewConstructorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_constructor);
    }

    public void newView(View v){
        TestConstructorView tcv = new TestConstructorView(this);
    }
}
