package com.example.hipper.quediaes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resultado = (Button) findViewById(R.id.idOk);

        resultado.setOnClickListener(obtenerFecha);
    }

    private View.OnClickListener obtenerFecha = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            calcularNombreDia();
        }
    };

    public void calcularNombreDia() {
        Funciones fec = new Funciones();

        EditText textoDia = (EditText) findViewById(R.id.idDia);
        EditText textoMes = (EditText) findViewById(R.id.idMes);
        EditText textoAnio = (EditText) findViewById(R.id.idAnio);

        String anioTex = textoAnio.getText().toString();
        String mesTex = textoMes.getText().toString();
        String diaTex = textoDia.getText().toString();

        boolean input = true;
        if(!fec.anioCorrecto(anioTex)) {
            Toast.makeText(this, "ingrese un año correctamente", Toast.LENGTH_LONG).show();
            input = false;
        }
        if(!fec.mesCorrecto(mesTex)) {
            Toast.makeText(this, "ingrese un mes correctamente", Toast.LENGTH_LONG).show();
            input = false;
        }
        if(input && !fec.diaCorrecto(Integer.valueOf(anioTex), mesTex, Integer.valueOf(diaTex))) {
            Toast.makeText(this, "Ingrese un dia correctamente", Toast.LENGTH_LONG).show();
            input = false;
        }

        if(input) {
            if (Double.valueOf(textoAnio.getText().toString()) > 8899) {
                Toast.makeText(this, "sobrepasado el rango de año", Toast.LENGTH_LONG).show();
            } else if (Double.valueOf(textoAnio.getText().toString()) < 1) {
                Toast.makeText(this, "ingrese un año positivo", Toast.LENGTH_LONG).show();
            } else {
                Integer anio = Integer.parseInt(textoAnio.getText().toString());
                Integer dia = Integer.parseInt(textoDia.getText().toString());
                String mes = textoMes.getText().toString();

                String resultado = fec.calculoDeDia(anio, mes, dia);
                final TextView textoResultado = (TextView) findViewById(R.id.idResultado);
                textoResultado.setText(resultado);
            }
        }
    }
}
