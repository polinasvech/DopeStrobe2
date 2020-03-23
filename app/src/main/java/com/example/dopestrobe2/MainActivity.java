package com.example.dopestrobe2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mLinearLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onScreenClick(View view) {
        Intent intent = new Intent(MainActivity.this, ScreenActivity.class);
        startActivity(intent);
    }

    public void onFlashLightClick(View view) {
        Intent intent = new Intent(MainActivity.this, FlashLightActivity.class);
        startActivity(intent);
    }

}
