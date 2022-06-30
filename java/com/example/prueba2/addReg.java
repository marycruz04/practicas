package com.example.prueba2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addReg extends AppCompatActivity {
    //variables globales
    Button btn_add;
    EditText nombre,apaterno,amaterno,edad,correo,dire,fecha,hora;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reg);
        this.setTitle("Crear Registro");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        //instanaciar variables con elementos de la interfaz
        nombre = findViewById(R.id.txtNombre);
        apaterno = findViewById(R.id.txtApaterno);
        amaterno = findViewById(R.id.txtAmaterno);
        edad = findViewById(R.id.txtEdad);
        correo = findViewById(R.id.txtCorreo);
        dire = findViewById(R.id.txtDire);
        fecha = findViewById(R.id.txtFecha);
        hora = findViewById(R.id.txtHora);
        btn_add = findViewById(R.id.btn_guardar);

        //metodo para eviar los datos al presionar el boton
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nombre.getText().toString().trim();
                String ap = apaterno.getText().toString().trim();
                String am = amaterno.getText().toString().trim();
                String ed = edad.getText().toString().trim();
                String co = correo.getText().toString().trim();
                String di = dire.getText().toString().trim();
                String fe = fecha.getText().toString().trim();
                String ho = hora.getText().toString().trim();
                if(n.isEmpty() && ap.isEmpty() && am.isEmpty() && ed.isEmpty() && co.isEmpty() && di.isEmpty() && fe.isEmpty() && ho.isEmpty()){
                    Toast.makeText(getApplicationContext(),"ingresar datos", Toast.LENGTH_SHORT).show();
                }else{
                    //metodo para capturar los elementos de las cajas de texto
                    postReg(n,ap,am,ed,co,di,fe,ho);
                }
            }
        });
    }
    //este metodo obtiene los datos de los textview y envia a la collection en firebase
    private void postReg(String n, String ap, String am, String ed, String co, String di, String fe, String ho) {
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre",n);
        map.put("Apaterno",ap);
        map.put("Amaterno",am);
        map.put("Edad",ed);
        map.put("Correo",co);
        map.put("Direcc",di);
        map.put("Fecha",fe);
        map.put("Hora",ho);

        mfirestore.collection("usuario").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(),"registro correcto",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"error al ingresar",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}