package com.kelly.conductor.Interfaz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kelly.conductor.Classes.Driver;
import com.kelly.conductor.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private Context context=this;
    private Button b_register;
    private DatabaseReference databaseReference;
    private EditText et_name,et_phone,et_company,
            et_licensePlate;
    private FirebaseDatabase firebaseData;
    private Spinner s_color,s_car;
    private List<String> listColor,listCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setElements();
        setActions();
    }
    private void setElements(){
        setTitle("Registro");
        b_register=(Button)findViewById(R.id.b_register);
        et_name=(EditText)findViewById(R.id.et_name);
        et_phone=(EditText)findViewById(R.id.et_phone);
        et_company=(EditText)findViewById(R.id.et_company);
        et_licensePlate=(EditText)findViewById(R.id.et_licensePlate);
        s_color=(Spinner) findViewById(R.id.s_color);
        s_car=(Spinner)findViewById(R.id.s_car);
    }
    private boolean verirfyContent(){
        if(et_name.getText().toString().length()==0|| et_company.getText().toString().length()==0||
                (et_phone.getText().toString().length()==0 ||et_phone.getText().toString().length()<9)
                ||(et_licensePlate.getText().toString().length()==0 ||et_licensePlate.getText().toString().length()<7)||
                s_color.getSelectedItem().toString().equals("\t")||s_car.getSelectedItem().toString().equals("\t"))
            return false;
        else return true;
    }
    private void setActions(){
        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!verirfyContent()) Toast.makeText(context, "Faltan Campos", Toast.LENGTH_SHORT).show();
                else{
                    //enviar data a Firebase
                    FirebaseApp.initializeApp(context);
                    firebaseData=FirebaseDatabase.getInstance();
                    databaseReference = firebaseData.getReference("/conductores");
                    Driver driver =new Driver(et_name.getText().toString(),et_phone.getText().toString(),
                            s_car.getSelectedItem().toString(),s_color.getSelectedItem().toString(),
                            et_company.getText().toString(),et_licensePlate.getText().toString());
                    databaseReference.child(et_phone.getText().toString()).setValue(driver);
                    //saving personal data
                    savingPersonalData();
                    //PersonalData.nameUser=et_name.getText().toString();
                    Intent intent = new Intent(context,MenuActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void savingPersonalData(){

    }
}
