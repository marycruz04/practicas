package com.example.mcje_2022_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText peso,altura;
    private Button calcular,eliminar;
    private TextView imc,descripcion,pesoalturarecomendado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        peso=findViewById(R.id.txtpeso);
        altura=findViewById(R.id.txtaltura);

        calcular=findViewById(R.id.btncalcular);
        eliminar=findViewById(R.id.btneliminar);

        imc=findViewById(R.id.txtimc);
        descripcion=findViewById(R.id.txdescripcion);
        pesoalturarecomendado=findViewById(R.id.txtideal);

    }
        public void operar(View view)
        {
            double npeso=Double.parseDouble(peso.getText().toString());
            double naltura=Double.parseDouble(altura.getText().toString());

            double resultadoimc=npeso/(naltura*naltura);
            imc.setText("IMC: " +String.format("%.2f",resultadoimc));
            if(resultadoimc<18.5)
                descripcion.setText("Bajo peso");
            else
                if (resultadoimc>18.5 && resultadoimc<=24.9)
                    descripcion.setText("Peso normal");
                else
                    if (resultadoimc>25 && resultadoimc<=29.9)
                        descripcion.setText("Sobrepeso");

        }
        public void borrar (View view)
        {
            peso.setText("");
            altura.setText("");
            imc.setText("");
            descripcion.setText("");
            pesoalturarecomendado.setText("");

    }
}