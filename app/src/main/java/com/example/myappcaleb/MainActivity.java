package com.example.myappcaleb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_caja1, edt_caja2;
    TextView txt_resultado;
    Button btn_calcular;
    Spinner spinner_operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_caja1 = findViewById(R.id.edt_caja1);
        edt_caja2 = findViewById(R.id.edt_caja2);
        txt_resultado = findViewById(R.id.txt_resultado);
        btn_calcular = findViewById(R.id.btn_calcular);
        spinner_operador = findViewById(R.id.spinner_operador);

        // Configurar Spinner con los operadores
        String[] operadores = {"+", "-", "*", "/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, operadores);
        spinner_operador.setAdapter(adapter);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular() {
        String num1 = edt_caja1.getText().toString();
        String num2 = edt_caja2.getText().toString();
        String operador = spinner_operador.getSelectedItem().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(this, "Ingrese ambos números", Toast.LENGTH_LONG).show();
            return;
        }

        double numero1 = Double.parseDouble(num1);
        double numero2 = Double.parseDouble(num2);
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Toast.makeText(this, "No puede dividirse por cero", Toast.LENGTH_LONG).show();
                    return;
                }
                break;
        }

        txt_resultado.setText(String.valueOf(resultado));
    }
}
