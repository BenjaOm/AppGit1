package com.example.loginsimple;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class TomarFoto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private StorageReference mStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar_foto);

        mStorage = FirebaseStorage.getInstance().getReference();
    }

    public void Photo(View v){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!= null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imFoto = (ImageView) findViewById(R.id.ivFoto);
            imFoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 500, 500, false));
            StorageReference fotoRef = mStorage.child("images/foto.png");
            //Generar arreglo de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //Convertir el bitmap al formato y calidad deseado
            imageBitmap.compress(Bitmap.CompressFormat.JPEG,100, baos);
            byte[] data1 = baos.toByteArray();
            //Subir a firebase la foto
            UploadTask upTask = fotoRef.putBytes(data1);

        }
    }
}