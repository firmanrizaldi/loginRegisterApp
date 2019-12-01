package com.example.loginregisterapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getBundleExtra("emailpass");
        String email = bundle.getString("email");
//        String password = bundle.getString("pass");

        auth = FirebaseAuth.getInstance();
        TextView tvUser = findViewById(R.id.tv_user);
        tvUser.setText(email);
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.signOut();
    }
}