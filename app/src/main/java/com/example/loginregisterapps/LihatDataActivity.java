package com.example.loginregisterapps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class LihatDataActivity extends AppCompatActivity {
    // [START define_database_reference]
    private DatabaseReference mDatabase;
    // [END define_database_reference]

    private FirebaseRecyclerAdapter<dataUser, DataAdapter> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRecycler = findViewById(R.id.rv_data);

        mManager = new LinearLayoutManager(this);
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);
        Query query = getQuery(mDatabase);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<dataUser>()
                .setQuery(query, dataUser.class)
                .build();
        mAdapter = new FirebaseRecyclerAdapter<dataUser, DataAdapter>(options) {
            @Override
            public DataAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new DataAdapter(inflater.inflate(R.layout.card_data, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull DataAdapter dataAdapter, int i, @NonNull dataUser dataUser) {

            }


        };
//
//        mAdapter = new FirebaseRecyclerAdapter<dataUser, DataAdapter>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull DataAdapter dataAdapter, int i, @NonNull dataUser dataUser) {
//
//            }
//
//            @Override
//            public PerusahaanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//                return new PerusahaanViewHolder(inflater.inflate(R.layout.item_perusahaan, parent, false));
//            }
//            @Override
//            protected void onBindViewHolder(@NonNull PerusahaanViewHolder holder, int position, @NonNull final Perusahaan model) {
//                holder.bindToPerusahaan(model, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        intent.setData(Uri.parse(model.website));
//                        startActivity(intent);
//                    }
//                });
//            }
//        };

        mAdapter.notifyDataSetChanged();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

    private Query getQuery(DatabaseReference mDatabase) {
        Query query = mDatabase.child("z-perusahaan");
        return query;
    }
}
