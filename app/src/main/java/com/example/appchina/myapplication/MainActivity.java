package com.example.appchina.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText edit;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                try {
                    a = Integer.parseInt(edit.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Oh!No   Exception!! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (isEquals(a)) {
                    Toast.makeText(MainActivity.this, "Yes!you got it!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Oh!No!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isEquals(int a) {
        if (a == 3) {
            return true;
        }
        return false;
    }
}
