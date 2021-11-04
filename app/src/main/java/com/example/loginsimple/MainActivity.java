package com.example.loginsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View v){

        EditText campo1 = this.findViewById(R.id.correo);
        String correo = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.pass);
        String pass = campo2.getText().toString();
        System.out.println(correo+" "+pass);

        if(correo.equals("c1") && pass.equals("123")){

            CheckBox cbRecuerdame = (CheckBox) findViewById(R.id.cbRecuerdame);
            boolean chequeado = cbRecuerdame.isChecked();
            if(chequeado == true){
                SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = datos.edit();
                editor.putString("correo", correo);
                editor.apply();
            }


            Intent i = new Intent(this, Principal1.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error en las credenciales", Toast.LENGTH_SHORT).show();
        }


    }

    public void crearCuenta(View v){
        Intent i = new Intent(this, RegistrarCuenta.class);
        startActivity(i);
    }
    public void SacarFoto(View v){
        Intent i = new Intent(this, TomarFoto.class);
        startActivity(i);
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences datos = PreferenceManager.getDefaultSharedPreferences(this);
        String correo = datos.getString("correo","");
        if(!correo.equals("")){
            Intent i = new Intent(this, Principal1.class);
            startActivity(i);
        }
    }
}