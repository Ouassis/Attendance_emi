package com.example.log_dash;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class QRCodeActivity extends AppCompatActivity {

    String data = "https://www.attendanceemi.com";
    int width = 500;
    int height = 500;

    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

    public QRCodeActivity() throws WriterException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        int pixelColor;

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelColor = bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE;
                bitmap.setPixel(x, y, pixelColor);
            }
        }

        ImageView imageView = findViewById(R.id.qrcode);
        imageView.setImageBitmap(bitmap);

    }
}
