package com.example.rezerwoojcom;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdActivity extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//    final Button rezerwujpok = findViewById(R.id.rezerwujpok);
    Hotel pok1 = null;
    Hotel pok2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Witaj User!");
        setSupportActionBar(toolbar);




        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                /////////////////////////// odzyt z bazy ////////////////////
                pok1 = dataSnapshot.child("room2").getValue(Hotel.class);
                TextView t1 = findViewById(R.id.text1);
                t1.setText(pok1.getQuantity());

                TextView t2 = findViewById(R.id.text2);
                t2.setText(pok1.getFloor());

                TextView t3 = findViewById(R.id.text3);
                t3.setText(pok1.getImage());

                TextView t4 = findViewById(R.id.text4);
                t4.setText(pok1.getCity());



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


}}
