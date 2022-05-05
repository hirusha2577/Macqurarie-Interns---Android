package com.example.macqurarieinterns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import static com.example.macqurarieinterns.Function.MyIntent.moveActivity;

public class AdminLoginActivity extends AppCompatActivity {

    private ImageButton back_btn, login_btn;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        back_btn = findViewById(R.id.back_btn);
        login_btn = findViewById(R.id.login_btn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveActivity(AdminLoginActivity.this,StartActivity.class);
            }
        });


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveActivity(AdminLoginActivity.this,AdminMainActivity.class);
            }
        });
    }
}