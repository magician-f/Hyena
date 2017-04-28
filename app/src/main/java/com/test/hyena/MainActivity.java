package com.test.hyena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.akita.hyena.button.CountDownButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CountDownButton btn1 = (CountDownButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.onStart();
            }
        });
    }
}
