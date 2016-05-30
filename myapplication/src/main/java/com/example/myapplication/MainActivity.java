package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);
    }

    public void login(View view) {
        if (isCorrectInfo(username.getText().toString(), password.getText().toString())) {
            Toast.makeText(MainActivity.this, "登陆成功！", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "登陆失败！", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isCorrectInfo(String username, String password) {
        if (username.equals(password)) {
            return true;
        }
        return false;
    }
}
