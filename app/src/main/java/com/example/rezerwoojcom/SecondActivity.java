package com.example.rezerwoojcom;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
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

public class SecondActivity extends AppCompatActivity {

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    Hotel pok1 = null;
    Hotel pok2 = null;
    Button odw1;
    Button odw2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Witaj w panelu Administratora!");
        setSupportActionBar(toolbar);

        odw1 = findViewById(R.id.odw1);
        odw2 = findViewById(R.id.odw2);
        final TextView stat1 = findViewById(R.id.status1);
        final TextView stat2 = findViewById(R.id.status2);




        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pok2 = dataSnapshot.child("room1").getValue(Hotel.class);
                pok1 = dataSnapshot.child("room2").getValue(Hotel.class);

                TextView nrPok1 = findViewById(R.id.nrPok1);
                nrPok1.setText(pok2.getFloor());
                TextView nrPok2 = findViewById(R.id.nrPok2);
                nrPok2.setText(pok1.getFloor());

                if(pok2.getName().equals("true")){
                    stat1.setText("zarezerwowany");
                    odw1.setEnabled(true);
                }
                else{
                    stat1.setText("wolny");
                    odw1.setEnabled(false);
                    odw1.setText("Wolny");
                }
                if(pok1.getName().equals("true")){
                    stat2.setText("zarezerwowany");
                    odw2.setEnabled(true);
                }
                else{
                    stat2.setText("wolny");
                    odw2.setEnabled(false);
                    odw2.setText("Wolny");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        odw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("room1").child("name").setValue("false");
                odw1.setEnabled(false);
                odw1.setText("Wolny");
                stat1.setText("wolny");

            }
        });

        odw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase.child("room2").child("name").setValue("false");
                odw2.setEnabled(false);
                odw2.setText("Wolny");
                stat2.setText("wolny");



            }
        });
    }


}
