package com.example.rezerwoojcom;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText User;
    private EditText Password;
    private Button Login;

    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

///////////
    Hotel przyklad = new Hotel();

    Hotel hotel = new Hotel();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
           przyklad =  dataSnapshot.child("rezerwooj").getValue(Hotel.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        ///////////////działający zapis do bazy///////////
//        mDatabase.child("rezerwooj").setValue(hotel);
//        mDatabase.child("user").setValue("user");







///////////działający odczyt////////
        TextView gejj = findViewById(R.id.abc);
        gejj.setText(przyklad.name);
/////////////////////






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        User =  findViewById(R.id.inputUser);
        Password = findViewById(R.id.inputPassword);
        Login = findViewById(R.id.btnZaloguj);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(User.getText().toString(), Password.getText().toString());
            }
        });
    }


    private void validate(String user, String password){
        if((user.equals("admin"))  && (password.equals("admin"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else if((user.equals("user")) && (password.equals("user"))){
            Intent intent2 = new Intent(MainActivity.this, thirdActivity.class);
            startActivity(intent2);
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Błąd");
            builder.setMessage("Nieprawidłowy login lub hasło");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }

    }

}
