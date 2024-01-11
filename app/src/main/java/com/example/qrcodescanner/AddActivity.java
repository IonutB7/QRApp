package com.example.qrcodescanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {


    EditText nume,cantitate,photo;
    @SuppressLint("StaticFieldLeak")
    public static EditText cod;
    Button addBtn,scnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nume =(EditText)findViewById(R.id.txtName);
        cantitate = (EditText) findViewById(R.id.txtCantitate);
        photo = (EditText) findViewById(R.id.txtImg);
        cod = (EditText) findViewById((R.id.txtCod));
        addBtn = (Button) findViewById(R.id.addBtn);
        scnBtn = (Button)findViewById(R.id.scnBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            insertData();
            clearAll();
            }
        });

        scnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),qrscanner.class));

            }
        });


    }
    private void insertData() {

        Map<String,Object> map = new HashMap<>();
        map.put("nume",nume.getText().toString());
        map.put("photo",photo.getText().toString());
        map.put("cantitate",cantitate.getText().toString());
        map.put("cod",cod.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Products").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this,"Data inserted successfully",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure( Exception e) {
                        Toast.makeText(AddActivity.this,"Error inserting data",Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void clearAll() {

        nume.setText("");
        cantitate.setText("");
        cod.setText("");
        photo.setText("");
    }


}