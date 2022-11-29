package com.example.mydraw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyCanvas myCanvas;
    private Button colorChangeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
    }

    private void getViews() {
        myCanvas = findViewById(R.id.myCanvas);
        colorChangeButton = findViewById(R.id.colorChange);
    }

    public void onClickButton(View view) {
        myCanvas.colorChange();
    }
}