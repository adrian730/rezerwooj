package com.example.rezerwoojcom;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Hotel pok2 = null;
    Button rezerwuj;
    Button nastepne;
    Boolean isReserved = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        rezerwuj = findViewById(R.id.rezerwuj);
        nastepne = findViewById(R.id.button_second);


        rezerwuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("room1").child("name").setValue("true");
                isReserved = true;
                rezerwuj.setEnabled(false);
                rezerwuj.setText("Zarezerwowano!");

            }
        });

        nastepne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main2Activity.this, thirdActivity.class);
        startActivity(intent2);
            }
        });

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                /////////////////////////// odzyt z bazy ////////////////////
                pok2 = dataSnapshot.child("room1").getValue(Hotel.class);
                TextView t1 = findViewById(R.id.texta);
                t1.setText(pok2.getQuantity());

                TextView t2 = findViewById(R.id.textb);
                t2.setText(pok2.getFloor());

                TextView t3 = findViewById(R.id.textc);
                t3.setText(pok2.getImage());

                TextView t4 = findViewById(R.id.textd);
                t4.setText(pok2.getCity());

         if( (pok2.getName()).equals("true")){
             rezerwuj.setEnabled(false);
             rezerwuj.setText("Zarezerwowano!");
             }
            else{
             rezerwuj.setEnabled(true);
             rezerwuj.setText("Rezerwuj!");
         }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }





}

