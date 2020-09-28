package com.example.lab2_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int CAMERA_PIC_REQUEST = 1;
    Bitmap bitmap;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Nombre = (EditText)findViewById(R.id.ptnombre);
        final EditText Contextura = (EditText)findViewById(R.id.ptcontextura);
        final EditText Fecha  = (EditText)findViewById(R.id.ptfecha);
        final EditText Altura = (EditText)findViewById(R.id.ptaltura);
        final EditText Peso = (EditText)findViewById(R.id.ptpeso);
        imageView = (ImageView)findViewById(R.id.ivmagen);

        Button Registrar = (Button)findViewById(R.id.btnregistrar);

        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent respuestaIntent = new Intent(getApplicationContext(),Activity_fichagym_final.class);

                respuestaIntent.putExtra("Nombre",Nombre.getText().toString());
                respuestaIntent.putExtra("Contextura",Contextura.getText().toString());
                respuestaIntent.putExtra("Fecha",Fecha.getText().toString());
                respuestaIntent.putExtra("Altura",Altura.getText().toString());
                respuestaIntent.putExtra("Peso",Peso.getText().toString());
                respuestaIntent.putExtra("Imagen", bitmap);
                startActivity(respuestaIntent);
            }
        });

        Button Foto = (Button)findViewById(R.id.btnfoto);
        Foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,CAMERA_PIC_REQUEST);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == CAMERA_PIC_REQUEST){
            if(resultCode == RESULT_OK){
                bitmap = (Bitmap)data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}


