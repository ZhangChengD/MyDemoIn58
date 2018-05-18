package com.example.aarmodule;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ModuleMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_main);
        findViewById(R.id.aar_main_textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModuleMainActivity.this.finish();
            }
        });
    }

}
