package com.example.loginsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegistrarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cuenta);



    }
    public void registrar(View v){
        //Recuperar el view
        EditText etUsuario = (EditText) findViewById(R.id.etUsuario);
        //Recuperar valor del view
        String usuario = etUsuario.getText().toString();
        //Recuperar el view
        EditText etCorreo = (EditText) findViewById(R.id.etCorreo);
        //Recuperar valor del view
        String correo = etCorreo.getText().toString();
        //Recuperar el view radio button
        RadioGroup rgGenero = (RadioGroup) findViewById(R.id.rgGenero);
        //Recuperar valor del view
        int id = rgGenero.getCheckedRadioButtonId();
        String genero = "";
        switch(id){
            case R.id.rbMasculino:
                genero = "Masculino";
                break;
            case R.id.rbFemenino:
                genero = "Femenino";
                break;
            default:
                Toast.makeText(this, "Error en la selección", Toast.LENGTH_SHORT).show();
        }

        //Recuperar view del spinner
        Spinner spCiudad = (Spinner) findViewById(R.id.spCiudad);
        //Recuperar el valor
        String ciudad = spCiudad.getSelectedItem().toString();

        //Recuperar el view
        EditText etpass = (EditText) findViewById(R.id.etpass);
        //Recuperar valor del view
        String password = etpass.getText().toString();
        //Recuperar el view
        EditText etpass2 = (EditText) findViewById(R.id.etpass2);
        //Recuperar valor del view
        String password2 = etpass2.getText().toString();

        if(password.equals(password2)){
            Toast.makeText(this, "Registro con exito", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show();
        }
    }
}