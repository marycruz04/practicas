package com.example.mcje_2022_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class triangulo extends AppCompatActivity {
    EditText l;
    Button calc;
    TextView Area,Perimetro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
        this.setTitle("Triangulo");

        l = findViewById(R.id.lado);
        calc = findViewById(R.id.calcular);
        Area = findViewById(R.id.Rarea);
        Perimetro = findViewById(R.id.Rperimetro);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double aux = Double.valueOf(l.getText().toString());
                double a= aux*aux/2;
                double p=0;
                for(int i=0;i<3;i++){
                    p= p+aux;
                }
                Area.setText(""+a);
                Perimetro.setText(""+p);
            }
        });
    }
}