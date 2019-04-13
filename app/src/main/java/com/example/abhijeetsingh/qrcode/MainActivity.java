package com.example.abhijeetsingh.qrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {


    EditText enteredText;
    Button generateButton;
    ImageView qrImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredText=(EditText)findViewById(R.id.textID);
        generateButton=(Button)findViewById(R.id.buttonID);
        qrImage=(ImageView)findViewById(R.id.qrID);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=enteredText.getText().toString().trim();
                MultiFormatWriter writer=new MultiFormatWriter();
                try
                {
                    BitMatrix bitMatrix=writer.encode(text, BarcodeFormat.QR_CODE,300,300);
                    BarcodeEncoder encoder=new BarcodeEncoder();
                    Bitmap b=encoder.createBitmap(bitMatrix);
                    qrImage.setImageBitmap(b);
                }
                catch (WriterException e)
                {
                    e.printStackTrace();

                }
            }
        });
    }
}
