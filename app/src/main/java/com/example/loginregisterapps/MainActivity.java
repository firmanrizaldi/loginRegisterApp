package com.example.loginregisterapps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    EditText npmET,namaET,kelasET,jurusanET;
    Button btn_simpan;
    String npm,nama,kelas,jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaET = findViewById(R.id.namaET);
        npmET = findViewById(R.id.npmET) ;
        kelasET = findViewById(R.id.kelasET);
        jurusanET = findViewById(R.id.jurusanET);



        Bundle bundle = getIntent().getBundleExtra("emailpass");
        String email = bundle.getString("email");
//        String password = bundle.getString("pass");

        auth = FirebaseAuth.getInstance();
        TextView tvUser = findViewById(R.id.tv_user);
        tvUser.setText(email);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = namaET.getText().toString() ;
                npm = npmET.getText().toString();
                kelas = kelasET.getText().toString();
                jurusan = jurusanET.getText().toString();

                mDatabase = FirebaseDatabase.getInstance().getReference("users");
                String userId = mDatabase.push().getKey() ;
                dataUser user = new dataUser(nama,npm,kelas,jurusan) ;
                mDatabase.child(userId).setValue(user);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.signOut();
    }
}