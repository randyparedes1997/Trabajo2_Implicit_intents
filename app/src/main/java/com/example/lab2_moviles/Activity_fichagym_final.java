package com.example.lab2_moviles;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class Activity_fichagym_final extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichagym_final);


        EditText edit_Nombre = (EditText) findViewById(R.id.ptnombrefinal);
        String Nombre = getIntent().getStringExtra("Nombre");
        edit_Nombre.setText(Nombre);

        EditText edit_Contextura = (EditText) findViewById(R.id.ptcontexturafinal);
        String Contextura = getIntent().getStringExtra("Contextura");
        edit_Contextura.setText(Contextura);

        EditText edit_Fecha = (EditText) findViewById(R.id.ptfechafinal);
        String Fecha = getIntent().getStringExtra("Fecha");
        edit_Fecha.setText(Fecha);

        EditText edit_Altura = (EditText) findViewById(R.id.ptalturafinal);
        String Altura = getIntent().getStringExtra("Altura");
        edit_Altura.setText(Altura);

        EditText edit_Peso = (EditText) findViewById(R.id.ptpesofinal);
        String Peso = getIntent().getStringExtra("Peso");
        edit_Peso.setText(Peso);

        ImageView iv_imagenfinal = (ImageView)findViewById(R.id.ivimagenfinal);
        Bitmap imagen2 = (Bitmap)getIntent().getParcelableExtra("Imagen");
        iv_imagenfinal.setImageBitmap(imagen2);
    }
}


