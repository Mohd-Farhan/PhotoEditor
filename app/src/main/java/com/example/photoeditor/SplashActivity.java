package com.example.photoeditor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextPaint;
import android.widget.TextView;
import android.widget.TimePicker;

public class SplashActivity extends AppCompatActivity {

    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //for changing the color of text
        title = findViewById(R.id.title);
        TextPaint paint = title.getPaint();
        float width = paint.measureText(getResources().getString(R.string.photo_editor));

        Shader textShader = new LinearGradient(0, 0, width, title.getTextSize(),
                new int[]{
                        Color.parseColor("#1B9AFF"),
                        Color.parseColor("#FF34D3"),
                }, null, Shader.TileMode.CLAMP);

        title.getPaint().setShader(textShader);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 4000);
    }
}