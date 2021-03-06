package com.example.loginregisterapps;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference mDatabase;
    EditText npmET, namaET, kelasET;
    String[] Operator = { "MIF","TIK","KAT","MBIS","RMIK"} ;
    Spinner jurusanET ;
    Button btn_simpan, btn_lihat_data;
    String npm, nama, kelas, jurusan;
    String Operator1 ;
    ProgressDialog dialog;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namaET = findViewById(R.id.namaET);
        npmET = findViewById(R.id.npmET);
        kelasET = findViewById(R.id.kelasET);
        jurusanET = findViewById(R.id.jurusanET);

        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, Operator) ;
        jurusanET.setAdapter(adapter);
        jurusanET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Operator1=adapter.getItem(position) ;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        Bundle bundle = getIntent().getBundleExtra("emailpass");
        String email = bundle.getString("email");
        auth = FirebaseAuth.getInstance();

        TextView tvUser = findViewById(R.id.tv_user);
        tvUser.setText(email);
        btn_lihat_data = findViewById(R.id.bukaList);
        btn_simpan = findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtn_simpan();

            }
        });
        btn_lihat_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent explicit = new Intent(MainActivity.this, MyListData.class);
                startActivity(explicit);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        auth.signOut();
    }

    public void setBtn_simpan() {
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading....");
        dialog.setCancelable(false);
        dialog.show();
        nama = namaET.getText().toString();
        npm = npmET.getText().toString();
        kelas = kelasET.getText().toString();
        jurusan = jurusanET.getSelectedItem().toString();

        mDatabase = FirebaseDatabase.getInstance().getReference("users").child("Mahasiswa");
        String userId = mDatabase.push().getKey();
        dataUser user = new dataUser(nama, npm, kelas, jurusan);
        mDatabase.child(userId).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(MainActivity.this, "Data tersimpan", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                namaET.setText("");
                npmET.setText("");
                kelasET.setText("");



            }

        });

    }
}